package com.google.code.stk.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class NewTweetCreatedEvent extends GwtEvent<NewTweetCreatedHandler> {

	public static final Type<NewTweetCreatedHandler> TYPE = new Type<NewTweetCreatedHandler>();

	@Override
	protected void dispatch(NewTweetCreatedHandler handler) {
		handler.onCreated(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<NewTweetCreatedHandler> getAssociatedType() {
		return TYPE;
	}
}