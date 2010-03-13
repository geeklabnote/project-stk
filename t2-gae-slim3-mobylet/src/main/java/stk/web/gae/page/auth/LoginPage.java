package stk.web.gae.page.auth;

import org.slim3.datastore.Datastore;
import org.t2framework.t2.annotation.core.ActionParam;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Form;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Redirect;
import org.t2framework.t2.spi.Navigation;

import stk.web.gae.meta.MemberMeta;
import stk.web.gae.model.Member;

@Page("/auth/")
public class LoginPage {

	@Default
	@ActionParam("login")
	public Navigation login(WebContext context , @Form LoginForm form){
		MemberMeta memberMeta = new MemberMeta();
		Member member = Datastore.query(Member.class)
									.filter(
											memberMeta.password.equal(form.password)
											,memberMeta.nickName.equal(form.nickName)
									).asSingle();

		if(member == null){
			return Redirect.to("/index");
		}

		context.getSession().setAttribute("member", member);
		return Redirect.to("/top");
	}

	public static class LoginForm{

		private String nickName;

		private String password;

		/**
		 * @param userId セットする userId
		 */
		public void setUserId(String userId) {
			this.nickName = userId;
		}
		/**
		 * @return userId
		 */
		public String getUserId() {
			return nickName;
		}
		/**
		 * @param password セットする password
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return password
		 */
		public String getPassword() {
			return password;
		}
		@Override
		public String toString() {
			return "LoginForm [password=" + password + ", userId=" + nickName
					+ "]";
		}
	}
}
