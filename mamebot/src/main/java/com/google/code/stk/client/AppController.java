package com.google.code.stk.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements ValueChangeHandler<String> {

	private final HandlerManager eventBus;

	private HasWidgets container;

	public AppController(HandlerManager eventBus) {
		super();
		this.eventBus = eventBus;
		bind();
	}

	public void go(HasWidgets container){
		this.container = container;

		this.container.clear();
		
		

	}

	private void bind() {
		History.addValueChangeHandler(this);

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> arg0) {

	}

}
