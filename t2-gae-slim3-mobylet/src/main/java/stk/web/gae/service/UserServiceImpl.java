package stk.web.gae.service;

import javax.servlet.http.HttpServletRequest;

import org.t2framework.t2.exception.T2BaseRuntimeException;

import stk.web.gae.StkConst;
import stk.web.gae.model.Member;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Userインターフェースを利用しないUserService
 * @author keisuke.oohashi
 *
 */
public class UserServiceImpl implements UserService {

	@Inject
	protected Injector injector;

	@Override
	public String createLoginURL(String destinationURL) {
		return createLoginURL(destinationURL, null);
	}

	@Override
	public String createLoginURL(String destinationURL, String authDomain) {
		return "/index";
	}

	@Override
	public String createLogoutURL(String destinationURL) {
		return createLogoutURL(destinationURL, null);
	}

	@Override
	public String createLogoutURL(String destinationURL, String authDomain) {
		return "/auth/logout";
	}

	@Override
	public User getCurrentUser() {
		throw new T2BaseRuntimeException("");
	}

	@Override
	public boolean isUserAdmin() {
		if(isUserLoggedIn() == false){
			return false;
		}
		return getMember().getAdmin();
	}

	@Override
	public boolean isUserLoggedIn() {
		return getMember() != null;
	}

	/**
	 * Memberを取得します
	 * @return Member
	 */
	public Member getMember(){
		HttpServletRequest request = injector.getInstance(HttpServletRequest.class);
		Object mem = request.getSession(true).getAttribute(StkConst.SESSION_KEY_MEMBER);

		return mem != null ?(Member)mem:null;
	}

}
