package stk.web.gae.page;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.controller.ControllerConstants;
import org.slim3.controller.validator.Errors;
import org.t2framework.slim3.tester.PageTestCase;
import org.t2framework.t2.contexts.Multipart;
import org.t2framework.t2.contexts.Request;
import org.t2framework.t2.contexts.impl.MultipartImpl;
import org.t2framework.t2.mock.MockUploadFileImpl;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;

import stk.web.gae.meta.ImageMeta;
import stk.web.gae.mock.GuiceMockFilterConfig;

import com.google.appengine.repackaged.com.google.common.base.StringUtil;



public class UploadPageTest extends PageTestCase {

	@Test
	public void run() throws Exception {
		tester.filter.init(new GuiceMockFilterConfig());
		Multipart multipart = new MultipartImpl();
		multipart.addUploadFile("img2", new MockUploadFileImpl());
		tester.request.setAttribute(Request.class.getName() + ".Multipart", multipart);
		tester.requestScope(ImageMeta.get().updaterComment.toString() , StringUtil.repeat("25", 251));
		tester.start("/upload");
		Navigation navigation = tester.getNavigation();
		assertThat(navigation, is(notNullValue()));
		assertThat(navigation.getClass().getSimpleName(), is("Forward"));
		Forward forward = (Forward) navigation;
		assertThat(tester.request.getAttribute(ControllerConstants.ERRORS_KEY) , notNullValue());
		Errors errors = (Errors)tester.request.getAttribute(ControllerConstants.ERRORS_KEY);
		assertThat(errors.isEmpty() , is(false));
		assertThat(forward.getPath(), is("/upload"));
	}

}
