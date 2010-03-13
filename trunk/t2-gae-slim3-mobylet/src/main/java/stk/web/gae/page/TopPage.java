package stk.web.gae.page;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.t2framework.commons.annotation.composite.RequestScope;
import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;

import stk.t2.gae.commons.annotation.Auth;
import stk.web.gae.StkConst;
import stk.web.gae.meta.ImageMeta;
import stk.web.gae.model.Image;
import stk.web.gae.model.Member;

@Page("/top")
@Auth(onlyAdmin=false)
public class TopPage {

	@Default
	public Navigation index(final WebContext context) {
		context.getRequest().setAttribute("member",
				(Member) context.getSession().getAttribute("member"));
		List<Image> list = Datastore.query(ImageMeta.get()).sort(ImageMeta.get().createDate.asc).asList();
		context.getRequest().setAttribute("list", list);

		return Forward.to(StkConst.JSP_PREFIX + "top/index.jsp");
	}

}
