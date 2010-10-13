package com.google.code.stk.client.ui.presenter;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.client.ClientFactory;
import com.google.code.stk.client.service.TwitterServiceAsync;
import com.google.code.stk.client.ui.display.ListDisplay;
import com.google.code.stk.client.ui.place.EditPlace;
import com.google.code.stk.client.ui.place.ListPlace;
import com.google.code.stk.client.ui.place.NewPlace;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ListPresenter extends AbstractActivity implements ListDisplay.Presenter{

	private final TwitterServiceAsync service;
	private final ClientFactory clientFactory;
	private final ListPlace place;
	private ListDisplay display;

	public ListPresenter(ListPlace place , ClientFactory clientFactory) {
		super();
		this.place = place;
		this.clientFactory = clientFactory;
		this.service = this.clientFactory.getTwitterService();
	}


	@Override
	public void clickNewButton() {
		clientFactory.getPlaceController().goTo(new NewPlace());
	}

	@Override
	public void clickDeleteAnchor(final Key key) {
		service.delete(key, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void arg0) {

				clientFactory.getPlaceController().goTo(new ListPlace("delete" , key.getId()));
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});
	}

	@Override
	public void clickEditAnchor(Key key) {
		clientFactory.getPlaceController().goTo(new EditPlace(key.getId()));
	}

	@Override
	public void savePinCode(String value) {
		service.registAccessToken(value, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable arg0) {

			}

			@Override
			public void onSuccess(Void arg0) {
				display.getPinCodeInputPanel().setVisible(false);
				display.getSavePinCodeButton().setEnabled(true);
				Window.alert("ピンコードを保存しました。");
			}
		});
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		display = clientFactory.getListDisplay();
		display.setPresenter(this);
		panel.setWidget(display);
		service.findAll(new AsyncCallback<List<AutoTweet>>() {

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

}
