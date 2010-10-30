package com.google.code.stk.client.ui.display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.Enums;
import com.google.code.stk.shared.KeyUtil;
import com.google.code.stk.shared.Enums.Bure;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.testing.PassthroughRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;

public class AutoTweetView extends Composite implements AutoTweetDisplay, Editor<AutoTweet>{

	@UiField
	TextBox tweet;

	@UiField
	TextBox startMMdd;

	@UiField
	TextBox endMMdd;

	@UiField(provided=true)
	ValueListBox<Enums.Cycle> cycle;

	@UiField(provided=true)
	ValueListBox<String> tweetHour;

	@UiField(provided=true)
	ValueListBox<Enums.Bure> bure;

	@UiField
	Button registButton;

	@UiField(provided=true)
	ValueListBox<Key> screenName;

	private static AutoTweetViewUiBinder uiBinder = GWT
			.create(AutoTweetViewUiBinder.class);

	private Presenter presenter;

	interface AutoTweetViewUiBinder extends UiBinder<Widget, AutoTweetView> {
	}

	public AutoTweetView(List<Key> screenNames) {

		cycle = new ValueListBox<Cycle>(Enums.<Enums.Cycle>getEnumRenderer());
		cycle.setAcceptableValues(Arrays.asList(Enums.Cycle.values()));

		bure = new ValueListBox<Bure>(Enums.<Enums.Bure>getEnumRenderer());
		bure.setAcceptableValues(Arrays.asList(Enums.Bure.values()));

		screenName = new ValueListBox<Key>(KeyUtil.KEY_NAME_RENDERER);
		screenName.setAcceptableValues(screenNames);

		tweetHour = new ValueListBox<String>(PassthroughRenderer.instance());

		List<String> hours = new ArrayList<String>();
		for(int i = 0; i < 24 ; i++){
			String hour = String.valueOf(i);

			if(hour.length() < 2){
				hour = 0 + hour;
			}
			hours.add(hour);
		}

		tweetHour.setAcceptableValues(hours);

		initWidget(uiBinder.createAndBindUi(this));

		initDisplay();
	}

	private void initDisplay() {
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
	public HasValue<Bure> getBure() {
		return bure;
	}

	@Override
	public HasValue<Cycle> getCycle() {
		return cycle;
	}

	@Override
	public HasValue<String> getEndMMdd() {
		return endMMdd;
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

	@Override
	public HasValue<Key> getScreenName() {
		return screenName;
	}

}
