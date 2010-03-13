package stk.web.gae.plugin;

import java.lang.reflect.Method;

import org.t2framework.commons.meta.MethodDesc;
import org.t2framework.commons.util.Logger;
import org.t2framework.t2.action.ActionContext;
import org.t2framework.t2.contexts.HttpMethod;
import org.t2framework.t2.plugin.AbstractPlugin;
import org.t2framework.t2.spi.Navigation;

import stk.t2.gae.commons.annotation.Auth;
import stk.t2.gae.commons.exception.AuthException;

import com.google.appengine.api.users.UserService;
import com.google.appengine.repackaged.com.google.common.base.StringUtil;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class AuthPlugin extends AbstractPlugin {

	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(AuthPlugin.class);

	@Inject
	UserService userService;

	@Inject
	Injector injector;

	@Override
	public Navigation beforeActionInvoke(ActionContext actionContext, MethodDesc targetMethod,
			Object page, Object[] args) {

		Auth auth = getAuthAnnotation(targetMethod);

		if(auth == null){
			return super.beforeActionInvoke(actionContext, targetMethod, page, args);
		}

		if(auth.useGaeUser()){
			userService = injector.getInstance(Key.get(UserService.class, Names.named("gae")));
		}

		if (!userService.isUserLoggedIn()) {
			addLoginLink2Request(actionContext);
		} else {
			addLogoutLink2Request(actionContext);
		}


		if (!userService.isUserLoggedIn()) {
			if (auth.onlyAdmin()) {
				throw new AuthException("この画面は利用できません。");
			}
			throw new AuthException("ログインしていない方は、利用できません。");
		}
		if (auth.onlyAdmin() && !userService.isUserAdmin()) {
			actionContext.getRequest().removeAttribute("logoutUrl");
			throw new AuthException("この画面は利用できません。");
		}

		return super.beforeActionInvoke(actionContext, targetMethod, page, args);
	}

	private Auth getAuthAnnotation(MethodDesc targetMethod) {
		Method m = targetMethod.getMethod();
		Class<?> c = m.getDeclaringClass();
		Auth classAnn = c.getAnnotation(Auth.class);
		Auth methodAnn = m.getAnnotation(Auth.class);
		if (classAnn == null && methodAnn == null) {
			return null;
		}

		Auth auth = methodAnn != null ? methodAnn : classAnn;
		return auth;
	}

	private void addLoginLink2Request(ActionContext actionContext) {
		if (actionContext.getRequest().isAjaxRequest() || actionContext.getRequest().isAmfRequest()) {
			return;
		}

		String url = actionContext.getRequest().getRequestURI();
		String queryString = null;
		if (actionContext.getRequest().getMethod() != HttpMethod.GET) {
			url = "/";
			queryString = "";
		} else {
			queryString = "";
		}

		String redirectUrl = url;
		if (!StringUtil.isEmpty(queryString)) {
			redirectUrl += url.contains("?") ? "&" : "?";
			redirectUrl += queryString;
		}
		String loginUrl = userService.createLoginURL(redirectUrl);
		actionContext.getRequest().setAttribute("loginUrl", loginUrl);
	}

	private void addLogoutLink2Request(ActionContext actionContext) {
		if (actionContext.getRequest().isAjaxRequest() || actionContext.getRequest().isAmfRequest()) {
			return;
		}
		String logoutUrl = userService.createLogoutURL("/");
		actionContext.getRequest().setAttribute("logoutUrl", logoutUrl);
	}
}
