package com.google.code.stk.client.ui.presenter;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.event.NewTweetCreatedEvent;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.AutoTweetDisplay;
import com.google.code.stk.client.ui.display.AutoTweetDisplay.Presenter;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class EditPresenter extends AbstractPresenter<AutoTweetDisplay> implements Presenter {

	private final TwitterServiceAsync service;
	private final long id;

	public EditPresenter(AutoTweetDisplay display, HandlerManager eventBus , TwitterServiceAsync service , long id) {
		super(display, eventBus);
		this.service = service;
		this.id = id;
		display.setPresenter(this);
	}

	@Override
	public void regist() {
		display.getRegistButton().setEnabled(false);
		service.regist(display.getData(), new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void arg0) {
				display.getRegistButton().setEnabled(true);
				eventBus.fireEvent(new NewTweetCreatedEvent());
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});
	}

	@Override
	protected void initView() {
		service.findAllAccessToeknOnlyKey(new AsyncCallback<List<Key>>() {

			@Override
			public void onFailure(Throwable arg0) {

			}

			@Override
			public void onSuccess(List<Key> arg0) {
				display.setScreenNames(arg0);
			}
		});
		service.findBy(id, new AsyncCallback<AutoTweet>() {

			@Override
			public void onSuccess(AutoTweet arg0) {
				container.clear();
				display.setData(arg0);
				container.add(display.asWidget());
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});
	}

}
