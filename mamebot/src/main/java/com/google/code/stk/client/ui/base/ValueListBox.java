package com.google.code.stk.client.ui.base;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;

public class ValueListBox extends ListBox implements HasValue<String> {

	private boolean valueChangeHandlerInitialized;

	@Override
	public String getValue() {
		return this.getValue(getSelectedIndex());
	}

	@Override
	public void setValue(String arg0) {
		for (int i = 0; i < this.getItemCount(); i++) {
			if (getValue(i).equals(arg0)) {
				setSelectedIndex(i);
				return;
			}
		}
	}

	@Override
	public void setValue(String arg0, boolean arg1) {

	}

	@Override
	@Deprecated
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		// Initialization code
		if (!valueChangeHandlerInitialized) {
			valueChangeHandlerInitialized = true;
			addChangeHandler(new ChangeHandler() {
				public void onChange(ChangeEvent event) {
					ValueChangeEvent.fire(ValueListBox.this, getValue());
				}
			});
		}
		return addHandler(handler, ValueChangeEvent.getType());
	}

}
