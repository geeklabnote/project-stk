package com.google.code.stk.shared.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AutoTweetTest extends AppEngineTestCase {

    private AutoTweet model = new AutoTweet();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
