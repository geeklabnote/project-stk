package com.google.code.stk.server.controller.sys.task.twitter;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.util.DateUtil;
import org.slim3.util.LocaleLocator;
import org.slim3.util.TimeZoneLocator;

import com.google.code.stk.server.meta.AutoTweetMeta;
import com.google.code.stk.server.service.TwitterServiceImpl;
import com.google.code.stk.shared.model.AutoTweet;

public class AutoTweetController extends Controller {

	Logger logger = Logger.getLogger(AutoTweetController.class.getName());

	AutoTweetMeta atm = AutoTweetMeta.get();

	@Override
	public Navigation run() throws Exception {
		Long id = asLong("id");

		if(id == null){
			logger.log(Level.SEVERE, "idがありません。");
			return null;
		}

		TwitterServiceImpl service = new TwitterServiceImpl();

		AutoTweet autoTweet = service.findBy(id);

		service.tweet(autoTweet.getScreenName() , autoTweet.getTweet());
		LocaleLocator.set(Locale.JAPAN);
		TimeZoneLocator.set(TimeZone.getTimeZone("Asia/Tohyo"));
		autoTweet.setLastTweetAt(DateUtil.toString(new Date(), "yyyyMMdd"));
		Datastore.put(autoTweet);
		return null;
	}
}
