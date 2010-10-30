package com.google.code.stk.client.ui.display;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.Enums;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

public interface AutoTweetDisplay extends IsWidget {
	HasValue<String> getTweet();

	HasValue<Enums.Bure> getBure();

	HasValue<Enums.Cycle> getCycle();

	HasValue<String> getEndMMdd();

	HasValue<String> getStartMMdd();

	HasValue<String> getTweetHour();

	void setPresenter(Presenter presenter);

	public interface Presenter{
		public void regist();
	}

	Button getRegistButton();

	HasValue<Key> getScreenName();
}
