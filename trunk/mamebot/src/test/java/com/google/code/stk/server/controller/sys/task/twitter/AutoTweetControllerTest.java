package com.google.code.stk.server.controller.sys.task.twitter;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AutoTweetControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/sys/task/twitter/autoTweet");
        AutoTweetController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
