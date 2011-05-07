package com.google.code.stk.server.controller.sys.cron;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

import com.google.code.stk.shared.Enums.Bure;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;

public class ScheduleControllerTest extends ControllerTestCase {

	@Test
	public void run() throws Exception {
		registAutoTweet();
		tester.start("/sys/cron/schedule");
		ScheduleController controller = tester.getController();
		assertThat(controller, is(notNullValue()));
		assertThat(tester.isRedirect(), is(false));
		assertThat(tester.getDestinationPath(), is(nullValue()));
	}

	public static void registAutoTweet() {

		AutoTweet at = new AutoTweet();

		at.setBure(Bure.FIX);
		at.setCycle(Cycle.DAY);
		at.setEndMMdd("1201");
		at.setStartMMdd("0101");
		at.setLastTweetAt("20101007");
		at.setTweetHour("08");
		Datastore.put(at);
	}
}
