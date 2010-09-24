package com.google.code.stk.server.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.service.TwitterService;
import com.google.code.stk.server.meta.AutoTweetMeta;
import com.google.code.stk.shared.model.AutoTweet;

public class TwitterServiceImpl implements TwitterService {

	private static AutoTweetMeta atm = AutoTweetMeta.get();

	@Override
	public void delete(Key key) {
		Datastore.delete(key);
	}

	@Override
	public List<AutoTweet> findAll() {
		return Datastore.query(atm).sortInMemory(atm.tweetHour.asc).asList();
	}

	@Override
	public AutoTweet findBy(Key key) {
		return Datastore.get(atm, key);
	}

	@Override
	public void regist(AutoTweet autoTweet) {
		Datastore.put(autoTweet);
	}

}
