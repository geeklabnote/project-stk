package com.google.code.stk.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditTweetClickEvent extends GwtEvent<EditTweetClickHandler> {

	private final long key;

	public EditTweetClickEvent(long key){
		this.key = key;

	}

	public static final Type<EditTweetClickHandler> TYPE = new Type<EditTweetClickHandler>();

	@Override
	protected void dispatch(EditTweetClickHandler handler) {
		handler.onClick(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EditTweetClickHandler> getAssociatedType() {
		return TYPE;
	}

	public long getKey(){
		return this.key;
	}
}
