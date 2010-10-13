package com.google.code.stk.client.ui.presenter;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.ClientFactory;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.AutoTweetDisplay;
import com.google.code.stk.client.ui.place.ListPlace;
import com.google.code.stk.client.ui.place.NewPlace;
import com.google.code.stk.shared.Enums.Bure;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class NewPresenter extends AbstractActivity implements AutoTweetDisplay.Presenter {

	private final TwitterServiceAsync service;
	private final NewPlace place;
	private final ClientFactory clientFactory;
	private AutoTweetDisplay display;

	public NewPresenter(NewPlace place , ClientFactory clientFactory) {
		super();
		this.place = place;
		this.clientFactory = clientFactory;
		this.service = this.clientFactory.getTwitterService();
	}

	@Override
	public void regist() {
		display.getRegistButton().setEnabled(false);

		AutoTweet data = new AutoTweet();
		data.setBure(Bure.valueOf(display.getBure().getValue()));
		data.setCycle(Cycle.valueOf(display.getCycle().getValue()));
		data.setStartMMdd(display.getStartMMdd().getValue());
		data.setEndMMdd(display.getEndMMdd().getValue());
		data.setTweet(display.getTweet().getValue());
		data.setTweetHour(display.getTweetHour().getValue());
		data.setScreenName(display.getScreenName().getValue());


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

		display = clientFactory.getAutoTweetDisplay();

		display.setPresenter(this);

		service.findAllAccessToeknOnlyKey(new AsyncCallback<List<Key>>() {

			@Override
			public void onFailure(Throwable arg0) {

			}

			@Override
			public void onSuccess(List<Key> arg0) {
				display.setScreenNames(arg0);
				panel.setWidget(display);
			}
		});

	}

}
