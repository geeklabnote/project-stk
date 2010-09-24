package com.google.code.stk.client.ui.presenter;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.event.DeleteTweetClickEvent;
import com.google.code.stk.client.event.EditTweetClickEvent;
import com.google.code.stk.client.event.NewTweetClickEvent;
import com.google.code.stk.client.service.TwitterService;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.ListDisplay;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListPresenter extends AbstractPresenter<ListDisplay> implements ListDisplay.Presenter{

	private TwitterServiceAsync twitterService = GWT.create(TwitterService.class);

	public ListPresenter(ListDisplay display, HandlerManager eventBus) {
		super(display, eventBus);
		display.setPresenter(this);
	}

	@Override
	protected void initView() {
		twitterService.findAll(new AsyncCallback<List<AutoTweet>>() {

			@Override
			public void onSuccess(List<AutoTweet> arg0) {
				display.drowTable(arg0);
			}

			@Override
			public void onFailure(Throwable arg0) {
				Window.alert(arg0.getMessage());
			}
		});
	}

	@Override
	public void clickNewButton() {
		eventBus.fireEvent(new NewTweetClickEvent());
	}

	@Override
	public void clickDeleteAnchor(Key key) {
		eventBus.fireEvent(new DeleteTweetClickEvent(key.getId()));
	}

	@Override
	public void clickEditAnchor(Key key) {
		eventBus.fireEvent(new EditTweetClickEvent(key.getId()));
	}

}
