package com.google.code.stk.shared.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import com.google.code.stk.server.model.TwAccessToken;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AccessTokenTest extends AppEngineTestCase {

    private TwAccessToken model = new TwAccessToken();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
