package com.google.code.stk.client.ui.display;

import java.util.List;

import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ListView extends Composite implements ListDisplay {

	@UiField
	Button newButton;

	@UiField
	InlineLabel sizeLabel;

	@UiField
	FlexTable table;

	@UiField
	Anchor pinCodeLink;

	@UiField
	FlowPanel pinCodeInputPanel;

	@UiField
	TextBox pinCode;

	@UiField
	Button savePinCode;

	private static ListViewUiBinder uiBinder = GWT
			.create(ListViewUiBinder.class);

	private Presenter presenter;

	interface ListViewUiBinder extends UiBinder<Widget, ListView>{
	}

	@Override
	public void drowTable(List<AutoTweet> tweetList) {
		table.clear();
		if (tweetList == null || tweetList.isEmpty()) {
			table.setText(0, 0, "tweetなし");
			return;
		}

		table.setText(0, 0, "ID");
		table.setText(0, 1, "対象");
		table.setText(0, 2, "内容");
		table.setText(0, 3, "時間");
		table.setText(0, 4, "間隔");
		table.setText(0, 5, "ブレ");
		table.setText(0, 6, "期間");
		table.setText(0, 7, "最終Tweet日");
		table.setText(0, 8, "修正");
		table.setText(0, 9, "削除");

		int row = 1;
		for (final AutoTweet autoTweet : tweetList) {
			table.getColumnFormatter().setWidth(1, "140em");
			table.getColumnFormatter().setWidth(3, "6em");
			table.getColumnFormatter().setWidth(4, "8em");
			table.setCellPadding(10);
			table.setCellSpacing(10);
			table.setText(row, 0, String.valueOf(autoTweet.getKey().getId()));
			table.setText(row, 1, autoTweet.getScreenName());
			table.setText(row, 2, autoTweet.getTweet());
			table.setText(row, 3, autoTweet.getTweetHour() + "時");
			table.setText(row, 4, autoTweet.getCycle().name());
			table.setText(row, 5, autoTweet.getBure().name());
			table.setText(row, 6, autoTweet.getStartMMdd() + " ～ " + autoTweet.getEndMMdd());
			table.setText(row, 7, autoTweet.getLastTweetAt());
			Anchor syusei = new Anchor("修正");
			syusei.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent arg0) {
					presenter.clickEditAnchor(autoTweet.getKey());
				}
			});

			table.setWidget(row, 8, syusei);
			Anchor sakujo = new Anchor("削除");

			sakujo.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent arg0) {
					presenter.clickDeleteAnchor(autoTweet.getKey());
				}
			});

			table.setWidget(row, 9, sakujo);
			row++;
		}
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public FlowPanel getPinCodeInputPanel(){
		return pinCodeInputPanel;
	}

	@UiHandler("newButton")
	void onClickNewButton(ClickEvent e){
		presenter.clickNewButton();
	}

	@UiHandler("pinCodeLink")
	public void onClickPinCodeLink(ClickEvent e){
		pinCodeInputPanel.setVisible(true);
	}

	@UiHandler("savePinCode")
	public void onClickSavePinCode(ClickEvent e){
		savePinCode.setEnabled(false);
		presenter.savePinCode(pinCode.getValue());
	}

	public ListView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Button getSavePinCodeButton() {
		return savePinCode;
	}
}
