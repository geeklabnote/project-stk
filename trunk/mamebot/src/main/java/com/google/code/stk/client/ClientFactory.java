package com.google.code.stk.client;

import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.AutoTweetDisplay;
import com.google.code.stk.client.ui.display.ListDisplay;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {

	ListDisplay getListDisplay();

	AutoTweetDisplay getAutoTweetDisplay();

	EventBus getEventBus();

	TwitterServiceAsync getTwitterService();

	PlaceController getPlaceController();

}
