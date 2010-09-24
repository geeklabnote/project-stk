package com.google.code.stk.client.ui.display;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.model.AutoTweet;

public interface ListDisplay extends Display{

	void drowTable(List<AutoTweet> tweetList);

	public interface Presenter{

		void clickNewButton();

		void clickDeleteAnchor(Key key);

		void clickEditAnchor(Key key);
	}

	public void setPresenter(Presenter presenter);


}