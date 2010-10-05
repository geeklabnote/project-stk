package com.google.code.stk.server.service;

import org.slim3.memcache.Memcache;
import org.slim3.util.ServletContextLocator;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.http.RequestToken;

public class TwitterUtil {

	public static Twitter getNonAuthTwitter(){
		String consumerKey = getConsumerKey();
		String secret = getSecret();

		return new TwitterFactory().getOAuthAuthorizedInstance(consumerKey, secret);
	}

	private static String getSecret() {
		String secret = ServletContextLocator.get().getInitParameter("twitter.consumerSecret");
		return secret;
	}

	private static String getConsumerKey() {
		String consumerKey = ServletContextLocator.get().getInitParameter("twitter.consumerKey");
		return consumerKey;
	}

	public static void saveRequestToken(RequestToken requestToken) {
		User user = UserServiceFactory.getUserService().getCurrentUser();
		Memcache.put(getRequestTokenKey(user) , requestToken);
	}

	public static RequestToken getMemcacheRequestToken(){
		User user = UserServiceFactory.getUserService().getCurrentUser();
		return Memcache.get(getRequestTokenKey(user));
	}

	private static String getRequestTokenKey(User user) {
		return user.getUserId() + "_requestToken";
	}


}
