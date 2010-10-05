package com.google.code.stk.client.ui.presenter;

import com.google.code.stk.client.ui.display.Display;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public abstract class AbstractPresenter<T extends Display> implements Presenter<T> {

	protected T display;

	protected HandlerManager eventBus;

	protected HasWidgets container;

	public AbstractPresenter(T display , HandlerManager eventBus){
		this.display = display;
		this.eventBus = eventBus;
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		initView();
	}

	protected abstract void initView();

}
