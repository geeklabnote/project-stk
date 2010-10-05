package com.google.code.stk.server.controller.oauth;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ShowPinCodeControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/oauth/showPinCode");
        ShowPinCodeController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
