package stk.web.gae.page;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.t2framework.commons.util.ArrayUtil;
import org.t2framework.t2.annotation.composite.POST;
import org.t2framework.t2.annotation.core.ActionParam;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.annotation.core.RequestParam;
import org.t2framework.t2.contexts.UploadFile;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.navigation.Redirect;
import org.t2framework.t2.spi.Navigation;

import stk.web.gae.StkConst;
import stk.web.gae.meta.ImageMeta;
import stk.web.gae.model.Image;
import stk.web.gae.model.ImgUnit;

import com.google.appengine.api.datastore.KeyFactory;

/**
 * アップロードページ
 * @author keisuke.oohashi
 */
@Page("/upload")
public class UploadPage {

	/** JSP_PREFIX */
	private static final String JSP_PREFIX = StkConst.JSP_PREFIX + "upload/";

	/** log */
	private Logger log = Logger.getLogger(UploadPage.class.getName());

	/**
	 * アップロードするための初期ページを表示します。
	 * @param context コンテクスト
	 * @return 初期ページ
	 */
	@Default
	public Navigation index(final WebContext context){
		return Forward.to(JSP_PREFIX + "index.jsp");
	}

	/**
	 * イメージデータを保存します。
	 * @param context context
	 * @param request request
	 * @param file アップロードファイル
	 * @param title タイトル
	 * @param updaterComment 投稿者コメント
	 * @return 成功時完了画面
	 */
	@POST
	@ActionParam("store")
	public Navigation store( WebContext context
							,HttpServletRequest request
							,UploadFile file
							,@RequestParam("title") String title
							,@RequestParam("updaterComment") String updaterComment
							){
		Validators v = new Validators(request);
		v.add(ImageMeta.get().title, v.required());
		v.add("img", v.byteType());
		v.add(ImageMeta.get().updaterComment , v.maxlength(500));
		if(v.validate() == false){
			return index(context);
		}

		if(file.get().length > StkConst.MAX_IMAGE_BYTES){
			return index(context);
		}

		if(!ArrayUtil.contains(StkConst.getSupportedExtensions() , FilenameUtils.getExtension(file.getName()).toLowerCase())){
			return index(context);
		}

		Image image = new Image();
		GlobalTransaction tx =Datastore.beginGlobalTransaction();
		try{
			image.setKey(Datastore.allocateId(Image.class));
			image.setTitle(title);
			image.setUpdaterComment(updaterComment);
			image.setCreateDate(new Date());
			List<ImgUnit> imgUnits = image.setImage(file.get());
			image.setFileName(file.getName());
			tx.put(imgUnits);
			context.getRequest().setAttribute("key", KeyFactory.keyToString(tx.put(image)));
			tx.commit();
		}catch (Exception e){
			tx.rollback();
			v.getErrors().put("put", e.getMessage());
		}
		return Redirect.to("/upload");
	}
}
