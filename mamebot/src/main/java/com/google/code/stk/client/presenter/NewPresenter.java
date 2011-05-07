package com.google.code.stk.client.presenter;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.ClientFactory;
import com.google.code.stk.client.place.ListPlace;
import com.google.code.stk.client.place.NewPlace;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.AutoTweetDisplay;
import com.google.code.stk.client.ui.display.AutoTweetView;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class NewPresenter extends AbstractActivity implements AutoTweetDisplay.Presenter {

	private final TwitterServiceAsync service;
	private final NewPlace place;
	private final ClientFactory clientFactory;
	private AutoTweetDisplay display;
	private EditPresenter.AutoTweetDriver driver = GWT.create(EditPresenter.AutoTweetDriver.class);

	public NewPresenter(NewPlace place , ClientFactory clientFactory) {
		super();
		this.place = place;
		this.clientFactory = clientFactory;
		this.service = this.clientFactory.getTwitterService();
	}

	@Override
	public void regist() {
		display.getRegistButton().setEnabled(false);

		AutoTweet data = driver.flush();

		if(driver.hasErrors()){

			return;
		}

		service.regist(data, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void arg0) {
				display.getRegistButton().setEnabled(true);
				clientFactory.getPlaceController().goTo(new ListPlace("new"));
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});
	}


	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {

		service.findAllAccessToeknOnlyKey(new AsyncCallback<List<Key>>() {

			@Override
			public void onFailure(Throwable arg0) {

			}

			@Override
			public void onSuccess(List<Key> arg0) {
				display = clientFactory.getAutoTweetDisplay(arg0);
				driver.initialize((AutoTweetView)display);
				driver.edit(new AutoTweet());
				display.setPresenter(NewPresenter.this);
				panel.setWidget(display);
			}
		});

	}

}
