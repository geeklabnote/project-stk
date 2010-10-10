package com.google.code.stk.client.ui.display;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasValue;

public interface AutoTweetDisplay extends Display {
	HasValue<String> getKeyId();

	HasValue<String> getTweet();

	HasValue<String> getBure();

	HasValue<String> getCycle();

	HasValue<String> getEndMMdd();

	HasValue<String> getStartMMdd();

	HasValue<String> getTweetHour();

	void setPresenter(Presenter presenter);

	public interface Presenter{
		public void regist();
	}

	Button getRegistButton();

	void setScreenNames(List<Key> arg0);

	HasValue<String> getScreenName();
}
