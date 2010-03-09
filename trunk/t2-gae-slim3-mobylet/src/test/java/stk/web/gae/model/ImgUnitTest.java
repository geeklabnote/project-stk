package stk.web.gae.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ImgUnitTest extends AppEngineTestCase {

    private ImgUnit model = new ImgUnit();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
