package com.google.code.stk.client.service;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TwitterServiceAsync {

	void findAll(AsyncCallback<List<AutoTweet>> callback);

	void findBy(Key key, AsyncCallback<AutoTweet> callback);

	void delete(Key key, AsyncCallback<Void> callback);

	void regist(AutoTweet autoTweet, AsyncCallback<Void> callback);

}
