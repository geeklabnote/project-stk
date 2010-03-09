package stk.web.gae.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import stk.web.gae.modelold.VoteProcess;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class VoteProcessTest extends AppEngineTestCase {

    private VoteProcess model = new VoteProcess();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
