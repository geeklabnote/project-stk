package com.google.code.stk.server.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.code.stk.client.service.TwitterService;
import com.google.code.stk.server.meta.AutoTweetMeta;
import com.google.code.stk.server.meta.TwAccessTokenMeta;
import com.google.code.stk.server.model.TwAccessToken;
import com.google.code.stk.shared.model.AutoTweet;

public class TwitterServiceImpl implements TwitterService {

	Logger logger = Logger.getLogger(TwitterServiceImpl.class.getName());

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
	public AutoTweet findBy(long keyId) {
		Key key = KeyFactory.createKey(atm.getKind(), keyId);
		return Datastore.get(atm, key);
	}

	@Override
	public List<Key> findAllAccessToeknOnlyKey(){
		return Datastore.query(TwAccessTokenMeta.get()).asKeyList();
	}

	@Override
	public void regist(AutoTweet autoTweet) {
		Datastore.put(autoTweet);
	}

	@Override
	public void registAccessToken(String pinCode){
		RequestToken requestToken = TwitterUtil.getMemcacheRequestToken();
		Twitter nonAuthTwitter = TwitterUtil.getNonAuthTwitter();
		try {
			AccessToken accessToken = nonAuthTwitter.getOAuthAccessToken(requestToken, pinCode);
			TwAccessToken twToken = new TwAccessToken();
			twToken.setKey(KeyFactory.createKey(TwAccessTokenMeta.get().getKind(), accessToken.getScreenName()));
			twToken.setAccessToken(accessToken);
			Datastore.put(twToken);
		} catch (TwitterException e) {
			logger.log(Level.SEVERE , e.getMessage() , e);
		}
	}

}
