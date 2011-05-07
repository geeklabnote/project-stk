package com.google.code.stk.server.controller.sys.cron;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.util.DateUtil;
import org.slim3.util.LocaleLocator;
import org.slim3.util.StringUtil;
import org.slim3.util.TimeZoneLocator;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Builder;
import com.google.appengine.api.taskqueue.TaskOptions.Method;
import com.google.code.stk.server.meta.AutoTweetMeta;
import com.google.code.stk.shared.Enums.Bure;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;

public class ScheduleController extends Controller {

	Logger logger = Logger.getLogger(ScheduleController.class.getName());

	AutoTweetMeta am = AutoTweetMeta.get();

	Random random = new Random();

	@Override
	public Navigation run() throws Exception {

		Date d = new Date();

		LocaleLocator.set(Locale.JAPANESE);
		TimeZoneLocator.set(TimeZone.getTimeZone("Asia/Tokyo"));

		String now = DateUtil.toString(d, "MMdd");
		String nowHH = DateUtil.toString(d, "HH");

		List<AutoTweet> atList = Datastore.query(am)
					.filter(
							am.tweetHour.equal(nowHH)
					).filterInMemory(
							am.startMMdd.lessThanOrEqual(now)
							,am.endMMdd.greaterThanOrEqual(now)
					).asList();

		for (AutoTweet autoTweet : atList) {
			Calendar instance = Calendar.getInstance();
			instance.setTime(d);
			instance = DateUtil.clearTimePart(instance);
			Cycle cycle = autoTweet.getCycle();

			if(StringUtil.isEmpty(autoTweet.getLastTweetAt())){
				registTaskQueue(autoTweet);
				continue;
			}

			if(cycle == Cycle.AT){
				continue;
			}

			if(cycle == Cycle.DAY){
				instance.add(Calendar.DAY_OF_MONTH, -1);

				logger.info(DateUtil.toString(instance.getTime(), "yyyyMMdd"));
				if(autoTweet.getLastTweetAt().equals(DateUtil.toString(instance.getTime(), "yyyyMMdd"))){
					registTaskQueue(autoTweet);
				}
				continue;
			}

			if(cycle == Cycle.MONTH){
				instance.add(Calendar.MONTH, -1);

				logger.info(DateUtil.toString(instance.getTime(), "yyyyMMdd"));
				if(autoTweet.getLastTweetAt().equals(DateUtil.toString(instance.getTime(), "yyyyMMdd"))){
					registTaskQueue(autoTweet);
				}
				continue;

			}

			if(cycle == Cycle.WEEK){
				instance.add(Calendar.DAY_OF_WEEK, -7);

				logger.info(DateUtil.toString(instance.getTime(), "yyyyMMdd"));
				if(autoTweet.getLastTweetAt().equals(DateUtil.toString(instance.getTime(), "yyyyMMdd"))){
					registTaskQueue(autoTweet);
				}
				continue;

			}

		}

		return null;
	}

	private void registTaskQueue(AutoTweet autoTweet) {
		Queue queue = QueueFactory.getQueue("autoTweet");
		TaskOptions op = Builder.withMethod(Method.POST)
								.url("/sys/task/twitter/autoTweet")
								.param("id",String.valueOf(autoTweet.getKey().getId()));
		if(autoTweet.getBure() == Bure.RANDOM){
			op = op.countdownMillis(random.nextInt(59) * 60 * 1000);
		}
		queue.add(op);
	}
}
