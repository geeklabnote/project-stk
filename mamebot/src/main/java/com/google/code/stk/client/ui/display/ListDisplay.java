package com.google.code.stk.client.ui.display;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public interface ListDisplay extends Display{

	void drowTable(List<AutoTweet> tweetList);

	public interface Presenter{

		void clickNewButton();

		void clickDeleteAnchor(Key key);

		void clickEditAnchor(Key key);

		void savePinCode(String value);
	}

	public void setPresenter(Presenter presenter);

	FlowPanel getPinCodeInputPanel();

	Button getSavePinCodeButton();

}