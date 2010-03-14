package stk.web.gae.page.auth;

import org.t2framework.t2.annotation.core.ActionPath;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;

import stk.web.gae.StkConst;

@Page("/auth/logout")
public class LogoutPage {

	@Default
	@ActionPath("logout")
	public Navigation index(WebContext context) {
		context.getSession().removeAttribute(StkConst.SESSION_KEY_MEMBER);
		return Forward.to("/auth/logout.jsp");
	}
}
