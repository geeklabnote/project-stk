package stk.web.gae.page.mobile;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.t2framework.commons.annotation.composite.RequestScope;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.navigation.Redirect;
import org.t2framework.t2.spi.Navigation;

import com.google.appengine.api.users.UserService;
import com.google.inject.Inject;

@Page("/m/")
@RequestScope
public class IndexPage {

	@Inject
	private Mobylet mobylet;

	@Inject
	private UserService userService;

	@Default
	public Navigation index(final WebContext context){
		String loginUrl = userService.createLoginURL("/m/");
		loginUrl += "&btmpl=mobile";
		if(mobylet.getCarrier() == Carrier.OTHER){
			return Redirect.to(stk.web.gae.page.IndexPage.class);
		}

		return Redirect.toOuterUrl(loginUrl);
	}
}
