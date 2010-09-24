package com.google.code.stk.client.ui.display;

import java.util.List;

import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class ListView extends Composite implements ListDisplay {

	@UiField
	Button newButton;

	@UiField
	InlineLabel sizeLabel;

	@UiField
	FlexTable table;

	private static ListViewUiBinder uiBinder = GWT
			.create(ListViewUiBinder.class);

	private Presenter presenter;

	interface ListViewUiBinder extends UiBinder<Widget, ListView>, ListDisplay {
	}

	public ListView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void drowTable(List<AutoTweet> tweetList) {
		table.clear();
		if (tweetList == null || tweetList.isEmpty()) {
			table.setText(0, 0, "tweetなし");
			return;
		}

		table.setText(0, 0, "id");
		table.setText(0, 1, "内容");
		table.setText(0, 2, "時間");
		table.setText(0, 3, "間隔");
		table.setText(0, 4, "ブレ");
		table.setText(0, 5, "期間");
		table.setText(0, 6, "修正");
		table.setText(0, 7, "削除");

		int row = 1;
		for (final AutoTweet autoTweet : tweetList) {

			table.setText(row, 0, String.valueOf(autoTweet.getKey().getId()));
			table.setText(row, 1, autoTweet.getTweet());
			table.setText(row, 2, autoTweet.getTweetHour() + "時");
			table.setText(row, 3, autoTweet.getCycle().name());
			table.setText(row, 4, autoTweet.getBure().name());
			table.setText(row, 5, autoTweet.getStartMMdd() + " ～ "
					+ autoTweet.getEndMMdd());
			Anchor syusei = new Anchor("修正");
			syusei.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent arg0) {
					presenter.clickEditAnchor(autoTweet.getKey());
				}
			});

			table.setWidget(row, 6, syusei);
			Anchor sakujo = new Anchor("削除");

			sakujo.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent arg0) {
					presenter.clickDeleteAnchor(autoTweet.getKey());
				}
			});

			table.setWidget(row, 7, sakujo);
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

}
