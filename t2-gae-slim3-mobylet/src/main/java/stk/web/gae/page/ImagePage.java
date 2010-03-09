package stk.web.gae.page;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.mobylet.core.image.ConnectionStream;
import org.mobylet.core.image.ImageCacheHelper;
import org.mobylet.core.util.InputStreamUtils;
import org.mobylet.core.util.SingletonUtils;
import org.slim3.datastore.Datastore;
import org.t2framework.commons.exception.IORuntimeException;
import org.t2framework.t2.annotation.core.ActionPath;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.annotation.core.Var;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.spi.Navigation;

import stk.t2.gae.commons.navigation.Img;
import stk.web.gae.meta.ImageMeta;
import stk.web.gae.model.Image;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.inject.servlet.RequestScoped;

@Page("/img")
@RequestScoped
public class ImagePage {

	private Logger logger = Logger.getLogger(ImagePage.class.getName());


	@Default
	@ActionPath("view/{key}")
	public Navigation view(@Var("key") String key, final WebContext context,
			HttpServletResponse resp) throws IORuntimeException, IOException {
		Key imgKey = KeyFactory.stringToKey(key);
		byte[] imageBytes = null;
		ImageCacheHelper cacheHelper = SingletonUtils.get(ImageCacheHelper.class);
		if (cacheHelper.existsCache(key + "-")) {
			//ReturnCacheImage
			ConnectionStream imageConnectionStream =
					new ConnectionStream(null, cacheHelper.get(key + "-"));
			imageBytes = InputStreamUtils.getAllBytes(imageConnectionStream.getInputStream());
			logger.info("get image by cache");
		} else {
			Image img = Datastore.get(ImageMeta.get(), imgKey);
			imageBytes = img.getImage();
			cacheHelper.put(key + "-", new ByteArrayInputStream(imageBytes));
			logger.info("get image by datastore");
		}
		return Img.from(imageBytes);
	}
}
