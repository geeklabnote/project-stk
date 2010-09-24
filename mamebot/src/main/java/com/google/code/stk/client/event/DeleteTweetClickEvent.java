package com.google.code.stk.client.event;

import com.google.appengine.api.datastore.Key;
import com.google.gwt.event.shared.GwtEvent;

public class DeleteTweetClickEvent extends GwtEvent<DeleteTweetClickHandler> {

	private final long key;

	public DeleteTweetClickEvent(long key){
		this.key = key;

	}

	public static final Type<DeleteTweetClickHandler> TYPE = new Type<DeleteTweetClickHandler>();

	@Override
	protected void dispatch(DeleteTweetClickHandler handler) {
		handler.onClick(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DeleteTweetClickHandler> getAssociatedType() {
		return TYPE;
	}

	public long getKey(){
		return this.key;
	}
}
