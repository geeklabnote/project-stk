package stk.web.gae.page;

import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.annotation.core.Page;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;

import com.google.inject.servlet.RequestScoped;


@Page("/comment")
@RequestScoped
public class CommentPage {

	@Default
	public Navigation index(){

		return Forward.to("");
	}
}
