package com.google.code.stk.client.ui.display;

import com.google.code.stk.client.ui.base.ValueListBox;
import com.google.code.stk.shared.Enums.Bure;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AutoTweetView extends Composite implements AutoTweetDisplay{

	@UiField
	TextBox tweet;

	@UiField
	TextBox startMMdd;

	@UiField
	TextBox endMMdd;

	@UiField
	ValueListBox cycle;

	@UiField
	ValueListBox tweetHour;

	@UiField
	ValueListBox bure;

	@UiField
	TextBox keyId;

	@UiField
	Button registButton;

	private static AutoTweetViewUiBinder uiBinder = GWT
			.create(AutoTweetViewUiBinder.class);

	private AutoTweet data;

	private Presenter presenter;

	interface AutoTweetViewUiBinder extends UiBinder<Widget, AutoTweetView> {
	}

	public AutoTweetView() {
		initWidget(uiBinder.createAndBindUi(this));
		initDisplay();
	}

	private void initDisplay() {
		for (Bure b : Bure.values()) {
			bure.addItem(b.name());
		}

		for(Cycle c : Cycle.values()){
			cycle.addItem(c.name());
		}

		for(int i = 0; i < 24 ; i++){
			String hour = String.valueOf(i);

			if(hour.length() < 2){
				hour = 0 + hour;
			}
			tweetHour.addItem(hour +"時" , hour);
		}
	}

	@UiHandler("registButton")
	public void onRegistButtonClick(ClickEvent e){
		registButton.setEnabled(false);
		presenter.regist();
	}

	@Override
	public Button getRegistButton(){
		return registButton;
	}

	@Override
	public HasValue<String> getBure() {
		return bure;
	}

	@Override
	public HasValue<String> getCycle() {
		return cycle;
	}

	@Override
	public HasValue<String> getEndMMdd() {
		return endMMdd;
	}

	@Override
	public HasValue<String> getKeyId() {
		return keyId;
	}

	@Override
	public HasValue<String> getStartMMdd() {
		return startMMdd;
	}

	@Override
	public HasValue<String> getTweetHour() {
		return tweetHour;
	}

	@Override
	public AutoTweet getData() {
		if(data == null){
			data = new AutoTweet();
		}

		data.setBure(Bure.valueOf(bure.getValue()));
		data.setCycle(Cycle.valueOf(cycle.getValue()));
		data.setStartMMdd(startMMdd.getValue());
		data.setEndMMdd(endMMdd.getValue());
		data.setTweet(tweet.getValue());
		data.setTweetHour(tweetHour.getValue());

		return data;
	}

	@Override
	public void setData(AutoTweet data) {
		this.data = data;
		bure.setValue(data.getBure().name());
		cycle.setValue(data.getCycle().name());
		keyId.setValue(String.valueOf(data.getKey().getId()));
		startMMdd.setValue(data.getStartMMdd());
		endMMdd.setValue(data.getEndMMdd());
		tweet.setValue(data.getTweet());
		tweetHour.setValue(data.getTweetHour());
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasValue<String> getTweet() {
		return tweet;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
