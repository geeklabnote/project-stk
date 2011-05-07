package com.google.code.stk.client.ui.base.column;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.KeyUtil;
import com.google.code.stk.shared.Enums.Bure;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.user.cellview.client.Column;

public class AutoTweetColumnDefImpl implements AutoTweetColumnDef {

	private static final long serialVersionUID = 1L;

	@Override
	public Column<AutoTweet, Bure> getBure() {
		return BURE;
	}

	@Override
	public Column<AutoTweet, Cycle> getCycle() {
		return CYCLE;
	}

	@Override
	public Column<AutoTweet, Date> getEndMMdd() {
		return END_MMDD;
	}

	@Override
	public Column<AutoTweet, String> getId() {
		return ID;
	}

	@Override
	public Column<AutoTweet, Date> getLastTweetAt() {
		return LAST_TWEET_AT;
	}

	@Override
	public Column<AutoTweet,String> getScreenName(List<Key> options) {

		SelectionCell selectionCell = new SelectionCell(KeyUtil.getKeyNames(options));
		return new Column<AutoTweet, String>(selectionCell) {
			@Override
			public String getValue(AutoTweet object) {
				return object.getScreenName();
			}
		};
	}

	@Override
	public Column<AutoTweet, Date> getStartMMdd() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Column<AutoTweet, String> getTweet() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Column<AutoTweet, String> getTweetHour() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
