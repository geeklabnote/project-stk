package com.google.code.stk.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface NewTweetCreatedHandler extends EventHandler {

	public void onCreated(NewTweetCreatedEvent e);

}
