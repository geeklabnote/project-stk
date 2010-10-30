package com.google.code.stk.client;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.service.TwitterService;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.AutoTweetDisplay;
import com.google.code.stk.client.ui.display.AutoTweetView;
import com.google.code.stk.client.ui.display.ListDisplay;
import com.google.code.stk.client.ui.display.ListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {

	private ListDisplay listDisplay = null;

	private PlaceController placeController = null;

	private SimpleEventBus eventBus;

	private TwitterServiceAsync twitterService;

	@Override
	public AutoTweetDisplay getAutoTweetDisplay(List<Key> screenNames) {

		return new AutoTweetView(screenNames);
	}

	@Override
	public EventBus getEventBus() {
		if(eventBus == null){
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}

	@Override
	public ListDisplay getListDisplay() {
		if(listDisplay == null){
			listDisplay = new ListView();
		}
		return listDisplay;
	}

	@Override
	public PlaceController getPlaceController() {
		if(placeController == null){
			placeController = new PlaceController(getEventBus());
		}
		return placeController;
	}

	@Override
	public TwitterServiceAsync getTwitterService() {
		if(twitterService == null){
			twitterService = GWT.create(TwitterService.class);
		}
		return twitterService;
	}

}
