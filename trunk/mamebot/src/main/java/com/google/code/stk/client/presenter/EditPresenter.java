package com.google.code.stk.client.presenter;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.ClientFactory;
import com.google.code.stk.client.place.EditPlace;
import com.google.code.stk.client.place.ListPlace;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.AutoTweetDisplay;
import com.google.code.stk.client.ui.display.AutoTweetView;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class EditPresenter extends AbstractActivity implements AutoTweetDisplay.Presenter {

	private final TwitterServiceAsync service;
	private final long id;
	private AutoTweet data;
	private final EditPlace place;
	private final ClientFactory clientFactory;
	private AutoTweetDisplay display;
	interface AutoTweetDriver extends SimpleBeanEditorDriver<AutoTweet, AutoTweetView> {}
	private AutoTweetDriver driver = GWT.create(AutoTweetDriver.class);

	public EditPresenter(EditPlace place ,ClientFactory clientFactory) {
		super();
		this.place = place;
		this.clientFactory = clientFactory;
		this.service = this.clientFactory.getTwitterService();
		this.id = this.place.getId();
	}

	@Override
	public void regist() {
		data = driver.flush();

		if(driver.hasErrors()){
			return;
		}
		service.regist(data, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void arg0) {
				display.getRegistButton().setEnabled(true);
				clientFactory.getPlaceController().goTo(new ListPlace("edit" ,data.getKey().getId()));
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
				display.setPresenter(EditPresenter.this);
			}
		});
		service.findBy(id, new AsyncCallback<AutoTweet>() {

			@Override
			public void onSuccess(AutoTweet result) {
				data = result;
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});

		Timer timer = new Timer() {

			@Override
			public void run() {
				if(data != null && display != null){
					driver.initialize((AutoTweetView)display);
					driver.edit(data);
					panel.setWidget(display);
					cancel();
				}
			}
		};

		timer.scheduleRepeating(100);
	}

}
