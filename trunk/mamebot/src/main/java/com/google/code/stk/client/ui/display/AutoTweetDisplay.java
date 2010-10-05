package com.google.code.stk.client.ui.display;

import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasValue;

public interface AutoTweetDisplay extends DataDisplay<AutoTweet> {
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
}
