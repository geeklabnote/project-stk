package com.google.code.stk.client.ui.presenter;

import com.google.code.stk.client.event.NewTweetCreatedEvent;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.AutoTweetDisplay;
import com.google.code.stk.client.ui.display.AutoTweetDisplay.Presenter;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class NewPresenter extends AbstractPresenter<AutoTweetDisplay> implements Presenter {

	private final TwitterServiceAsync service;

	public NewPresenter(AutoTweetDisplay display, HandlerManager eventBus , TwitterServiceAsync service) {
		super(display, eventBus);
		this.service = service;
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
		container.clear();
		container.add(display.asWidget());
	}

}
