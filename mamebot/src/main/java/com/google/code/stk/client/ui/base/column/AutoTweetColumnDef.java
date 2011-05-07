package com.google.code.stk.client.ui.base.column;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.Enums;
import com.google.code.stk.shared.Enums.Bure;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;

public interface AutoTweetColumnDef extends Serializable {

	public static final TextColumn<AutoTweet> ID = new TextColumn<AutoTweet>() {
		@Override
		public String getValue(AutoTweet at) {
			return String.valueOf(at.getKey().getId());
		}
	};

	public Column<AutoTweet , String> getId();

	public static final Column<AutoTweet , String> TWEET
	= new Column<AutoTweet , String>(new EditTextCell()) {
		@Override
		public String getValue(AutoTweet at) {
			return String.valueOf(at.getTweet());
		}
	};

	public Column<AutoTweet , String> getTweet();

	public static final Column<AutoTweet , Bure> BURE
	= new Column<AutoTweet , Bure>(new EnumSelectionCell<Enums.Bure>(Enums.Bure.class)) {
		@Override
		public Bure getValue(AutoTweet at) {
			return at.getBure();
		}
	};

	public Column<AutoTweet , Bure> getBure();

	public static final Column<AutoTweet , Cycle> CYCLE
	= new Column<AutoTweet , Cycle>(new EnumSelectionCell<Enums.Cycle>(Enums.Cycle.class)) {
		@Override
		public Cycle getValue(AutoTweet at) {
			return at.getCycle();
		}
	};

	public Column<AutoTweet , Cycle> getCycle();

	public static final Column<AutoTweet , Date> START_MMDD = new Column<AutoTweet , Date>(new DatePickerCell(DateTimeFormat.getFormat("MM/dd"))){

		@Override
		public Date getValue(AutoTweet arg0) {
			return DateTimeFormat.getFormat("MMdd").parse(arg0.getStartMMdd());
		}

	};

	public Column<AutoTweet , Date> getStartMMdd();

	public static final Column<AutoTweet , Date> END_MMDD = new Column<AutoTweet , Date>(new DatePickerCell(DateTimeFormat.getFormat("MM/dd"))){

		@Override
		public Date getValue(AutoTweet arg0) {
			return DateTimeFormat.getFormat("MMdd").parse(arg0.getEndMMdd());
		}

	};

	public Column<AutoTweet , Date> getEndMMdd();

	public static final List<String> HOUR_LIST = Arrays.asList("01" , "02" , "03" , "04" , "05" , "06" , "07" , "08" , "09" , "10" ,"11" , "12"
																, "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" , "22" , "23"
													);

	public static final Column<AutoTweet , String> TWEET_HOUR = new Column<AutoTweet , String>(new SelectionCell(HOUR_LIST)) {
		@Override
		public String getValue(AutoTweet at) {
			return at.getTweetHour();
		}
	};

	public Column<AutoTweet , String> getTweetHour();

	public static final Column<AutoTweet , Date> LAST_TWEET_AT = new Column<AutoTweet , Date>(new DateCell(DateTimeFormat.getFormat("yyyy/MM/dd"))){
		@Override
		public Date getValue(AutoTweet arg0) {
			return DateTimeFormat.getFormat("yyyyMMdd").parse(arg0.getLastTweetAt());
		}
	};

	public Column<AutoTweet , Date> getLastTweetAt();

	public Column<AutoTweet, String> getScreenName(List<Key> options);



}
