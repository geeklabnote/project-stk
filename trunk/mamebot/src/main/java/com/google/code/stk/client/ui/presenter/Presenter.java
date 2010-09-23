package com.google.code.stk.client.ui.presenter;

import com.google.code.stk.client.ui.display.Display;
import com.google.gwt.user.client.ui.HasWidgets;

public abstract interface Presenter<T extends Display> {
	public abstract void go(final HasWidgets container);
}
