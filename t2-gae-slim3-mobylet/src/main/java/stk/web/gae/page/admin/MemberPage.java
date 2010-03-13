package stk.web.gae.page.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jsp.ah.datastoreViewerBody_jsp;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.t2framework.t2.annotation.composite.GET;
import org.t2framework.t2.annotation.composite.POST;
import org.t2framework.t2.annotation.core.ActionParam;
import org.t2framework.t2.annotation.core.ActionPath;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Form;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.annotation.core.Var;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.navigation.Redirect;
import org.t2framework.t2.spi.Navigation;

import stk.t2.gae.commons.annotation.Auth;
import stk.web.gae.StkConst;
import stk.web.gae.meta.MemberMeta;
import stk.web.gae.model.Member;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.repackaged.com.google.common.base.StringUtil;
import com.google.inject.servlet.RequestScoped;

@Page("/admin/member")
@Auth(onlyAdmin=true)
public class MemberPage {

	public static class MemberForm{
		private String admin;

		private String nickName;

		private String password;

		/**
		 * @return admin
		 */
		public String getAdmin() {
			return admin;
		}

		public String getNickName() {
			return nickName;
		}

		public String getPassword() {
			return password;
		}

		/**
		 * @param admin セットする admin
		 */
		public void setAdmin(final String admin) {
			this.admin = admin;
		}

		public void setNickName(final String nickName) {
			this.nickName = nickName;
		}

		public void setPassword(final String password) {
			this.password = password;
		}
	}

	@GET
	@ActionPath("delete/{key}")
	public Navigation delete(final WebContext context ,@Var("key") String key){
		Key deleteKey = KeyFactory.stringToKey(key);
		Datastore.delete(deleteKey);
		return Redirect.to(MemberPage.class);
	}

	@POST
	@ActionParam("add")
	public Navigation add(final WebContext context , HttpServletRequest request , @Form final MemberForm form ){
		Validators v = new Validators(request);

		v.add(MemberMeta.get().nickName, v.required())
			.add(MemberMeta.get().password, v.required());

		if(v.validate() == false){
			return index(context);
		}
		Member member = new Member();
		BeanUtil.copy(form, member);
		member.setAdmin(!StringUtil.isEmpty(form.getAdmin()));
		Datastore.put(member);

		return Redirect.to(MemberPage.class);
	}

	@Default
	public Navigation index(final WebContext context){
		final List<Member> memberList = Datastore.query(new MemberMeta()).asList();
		context.getRequest().setAttribute("memberList", memberList);
		return Forward.to(StkConst.JSP_PREFIX + "admin/member/index.jsp");
	}
}
