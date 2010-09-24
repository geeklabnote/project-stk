package com.google.code.stk.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class NewTweetClickEvent extends GwtEvent<NewTweetClickHandler> {

	public static final Type<NewTweetClickHandler> TYPE = new Type<NewTweetClickHandler>();

	@Override
	protected void dispatch(NewTweetClickHandler handler) {
		handler.onClick(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<NewTweetClickHandler> getAssociatedType() {
		return TYPE;
	}

}
