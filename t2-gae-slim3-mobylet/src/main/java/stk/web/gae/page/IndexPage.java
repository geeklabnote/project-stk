package stk.web.gae.page;

import org.t2framework.commons.util.Logger;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;

import com.google.inject.servlet.RequestScoped;

@Page("/index")
@RequestScoped
public class IndexPage {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(IndexPage.class);

	@Default
	public Navigation index(final WebContext context) {
		return Forward.to("index.jsp");
	}
}
