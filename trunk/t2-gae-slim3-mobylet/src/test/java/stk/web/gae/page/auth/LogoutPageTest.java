package stk.web.gae.page.auth;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;
import org.t2framework.slim3.tester.PageTestCase;

import stk.web.gae.StkConst;
import stk.web.gae.model.Member;

public class LogoutPageTest extends PageTestCase {

    @Test
    public void run() throws Exception {
        tester.sessionScope(StkConst.SESSION_KEY_MEMBER, new Member());
    	tester.start("/auth/logout");
        Navigation navigation = tester.getNavigation();
        assertThat(navigation, is(notNullValue()));
        assertThat(navigation.getClass().getSimpleName(), is("Forward"));
        Forward forward = (Forward)navigation;
        assertThat(forward.getPath(), is("/auth/logout.jsp"));
        assertNull(tester.sessionScope(StkConst.SESSION_KEY_MEMBER));
    }
}
