package com.google.code.stk.client.ui.base.column;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.cell.client.AbstractInputCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

abstract public class ClassSelectionCell<T> extends AbstractInputCell<T, String> {

	private final List<T> options;

	interface Template extends SafeHtmlTemplates {
		@Template("<option value=\"{0}\">{0}</option>")
		SafeHtml deselected(String option);

		@Template("<option value=\"{0}\" selected=\"selected\">{0}</option>")
		SafeHtml selected(String option);
	}

	private static Template template;

	private HashMap<T, Integer> indexForOption = new HashMap<T, Integer>();

	abstract public String render(T viewData);

	public ClassSelectionCell(List<T> options) {
		super("change");
		if (template == null) {
			template = GWT.create(Template.class);
		}

		this.options = options;
		int index = 0;
		for (T option : options) {
			indexForOption.put(option, index++);
		}
	}


	@Override
	public void onBrowserEvent(Context context, Element parent, T value, NativeEvent event, ValueUpdater<T> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		String type = event.getType();
		if ("change".equals(type)) {
			SelectElement select = parent.getFirstChild().cast();
			T newValue = options.get(select.getSelectedIndex());
			setViewData(context.getKey(), render(newValue));
			finishEditing(parent, newValue, context.getKey(), valueUpdater);
			if (valueUpdater != null) {
				valueUpdater.update(newValue);
			}
		}
	}


	@Override
	public void render(Context context, T value, SafeHtmlBuilder sb){
		// Get the view data.
		String viewData = getViewData(context.getKey());
		if (viewData != null && viewData.equals(value)) {
			clearViewData(context.getKey());
			viewData = null;
		}

		int selectedIndex = getSelectedIndex(value);
		sb.appendHtmlConstant("<select tabindex=\"-1\">");
		int index = 0;
		for (T option : options) {
			if (index++ == selectedIndex) {
				sb.append(template.selected(render(option)));
			} else {
				sb.append(template.deselected(render(option)));
			}
		}
		sb.appendHtmlConstant("</select>");
	}

	private int getSelectedIndex(T value) {
		Integer index = indexForOption.get(value);
		if (index == null) {
			return -1;
		}
		return index.intValue();
	}

}
