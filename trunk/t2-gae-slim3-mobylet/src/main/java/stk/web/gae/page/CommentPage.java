package stk.web.gae.page;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.ControllerConstants;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.t2framework.t2.action.ErrorInfo;
import org.t2framework.t2.annotation.composite.GET;
import org.t2framework.t2.annotation.composite.POST;
import org.t2framework.t2.annotation.core.ActionParam;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.navigation.Redirect;
import org.t2framework.t2.spi.Navigation;

import stk.t2.gae.commons.annotation.Auth;
import stk.web.gae.meta.CommentMeta;
import stk.web.gae.model.Comment;
import stk.web.gae.model.Image;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * コメントページ
 * @author keisuke.oohashi
 */
@Page("/comment")
@Auth
public class CommentPage {


	@Default
	@GET
	public Navigation index(WebContext context){
		return Forward.to("/comment/index.jsp");
	}


	/**
	 * コメントを投稿します。
	 * @param context context
	 * @param request request
	 * @param errorInfo エラー情報
	 * @param form フォーム
	 * @return トップ
	 */
	@POST
	@ActionParam("vote")
	public Navigation vote(WebContext context
							,HttpServletRequest request
							,ErrorInfo errorInfo
							,CommentForm form
							) {

		Validators v = makeCommentValidators(request);

		if(v.validate()){
			context.getSession().setAttribute(ControllerConstants.ERRORS_KEY, v.getErrors());
			return Redirect.to("/top");
		}

		registComment(form);

		return Redirect.to("/top");
	}


	private void registComment(CommentForm form) {
		GlobalTransaction tx =Datastore.beginGlobalTransaction();
		try{
			Comment comment = new Comment();
			Key imgKey = KeyFactory.stringToKey(form.key);
			comment.getImageRef().setModel(tx.get(Image.class, imgKey));
			comment.setValue(form.value);
			comment.setUpdateDate(new Date());
			tx.put(comment);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
	}


	private Validators makeCommentValidators(HttpServletRequest request) {
		Validators v = new Validators(request);
		v.add("key", v.required());
		v.add(CommentMeta.get().value, v.required()  ,v.maxlength(500));
		return v;
	}


	/**
	 * コメントフォーム
	 * @author keisuke.oohashi
	 */
	public static class CommentForm {

		private String value;

		private String key;


		/**
		 * valueを設定します。
		 * @param value セットするvalue
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * valueを取得します。
		 * @return value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * keyを設定します。
		 * @param key セットするkey
		 */
		public void setKey(String key) {
			this.key = key;
		}

		/**
		 * keyを取得します。
		 * @return key
		 */
		public String getKey() {
			return key;
		}

	}

}
