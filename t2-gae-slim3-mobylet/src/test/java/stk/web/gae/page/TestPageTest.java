package stk.web.gae.page;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.t2framework.slim3.tester.PageTestCase;
import org.t2framework.t2.navigation.Forward;
import org.t2framework.t2.spi.Navigation;

public class TestPageTest extends PageTestCase {

	@Test
	public void run() throws Exception {
		
		tester.start("/test");
		Navigation navigation = tester.getNavigation();
		assertThat(navigation, is(notNullValue()));
		assertThat(navigation.getClass().getSimpleName(), is("Forward"));
		Forward forward = (Forward) navigation;
		assertThat(forward.getPath(), is("/test.jsp"));
	}
}
