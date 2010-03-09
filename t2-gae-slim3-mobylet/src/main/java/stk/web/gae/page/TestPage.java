package stk.web.gae.page;

import org.t2framework.t2.annotation.core.Default;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;
import org.t2framework.t2.annotation.core.Page;

@Page("/test")
public class TestPage {

    @Default
    public Navigation index() {
        return Forward.to("/test.jsp");
    }
}
