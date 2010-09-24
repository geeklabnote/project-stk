package com.google.code.stk.client.service;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service.s3gwt")
public interface TwitterService extends RemoteService {

	List<AutoTweet> findAll();

	AutoTweet findBy(Key key);

	void delete(Key key);

	void regist(AutoTweet autoTweet);

}
