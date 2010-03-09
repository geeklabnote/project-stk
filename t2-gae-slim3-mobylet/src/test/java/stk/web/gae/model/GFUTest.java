package stk.web.gae.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GFUTest extends AppEngineTestCase {

    private GFU model = new GFU();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
