package com.google.code.stk.client.ui.base.column;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.code.stk.shared.Enums;
import com.google.code.stk.shared.Enums.Cycle;
import com.google.code.stk.shared.model.AutoTweet;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;

public class AutoTweetColumnDef implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final TextColumn<AutoTweet> ID = new TextColumn<AutoTweet>() {
		@Override
		public String getValue(AutoTweet at) {
			return String.valueOf(at.getKey().getId());
		}
	};

	public static final Column<AutoTweet , String> TWEET = new Column<AutoTweet , String>(new EditTextCell()) {
		@Override
		public String getValue(AutoTweet at) {
			return String.valueOf(at.getTweet());
		}
	};

	public static final Column<AutoTweet , String> BURE
	= new Column<AutoTweet , String>(new SelectionCell(Enums.names(Enums.Bure.class))) {
		@Override
		public String getValue(AutoTweet at) {
			return at.getBure().name();
		}
	};

	private static final List<String> CYCLE_LIST = new ArrayList<String>();
	static{
		for (Cycle bure : Enums.Cycle.values()) {
			CYCLE_LIST.add(bure.name());
		}
	}

	public static final Column<AutoTweet , String> CYCLE
	= new Column<AutoTweet , String>(new SelectionCell(Enums.names(Enums.Cycle.class))) {
		@Override
		public String getValue(AutoTweet at) {
			return at.getCycle().name();
		}
	};

	private static final DateTimeFormat format = DateTimeFormat.getFormat("MM/dd");

	public static final Column<AutoTweet , Date> START_MMDD = new Column<AutoTweet , Date>(new DatePickerCell(format)){

		@Override
		public Date getValue(AutoTweet arg0) {
			return format.parse(arg0.getStartMMdd());
		}

	};

	public static final Column<AutoTweet , Date> END_MMDD = new Column<AutoTweet , Date>(new DatePickerCell(format)){

		@Override
		public Date getValue(AutoTweet arg0) {
			return format.parse(arg0.getEndMMdd());
		}

	};

	public static final List<String> HOUR_LIST = Arrays.asList("01" , "02" , "03" , "04" , "05" , "06" , "07" , "08" , "09" , "10" ,"11" , "12"
																, "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" , "22" , "23"
													);

	public static final Column<AutoTweet , String> TWEET_HOUR = new Column<AutoTweet , String>(new SelectionCell(HOUR_LIST)) {
		@Override
		public String getValue(AutoTweet at) {
			return at.getTweetHour();
		}
	};

	public static final Column<AutoTweet , Date> LST_TWEET_AT = new Column<AutoTweet , Date>(new DateCell(DateTimeFormat.getFormat("yyyy/MM/dd"))){

		@Override
		public Date getValue(AutoTweet arg0) {
			return DateTimeFormat.getFormat("yyyyMMdd").parse(arg0.getLastTweetAt());
		}

	};

	public static final Column<AutoTweet , String> SCREEN_NAME = new Column<AutoTweet , String>(new SelectionCell(new ArrayList<String>() )){
		@Override
		public String getValue(AutoTweet arg0) {
			return arg0.getScreenName();
		}

	};


}
