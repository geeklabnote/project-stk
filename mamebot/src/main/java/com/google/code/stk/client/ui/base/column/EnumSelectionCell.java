package com.google.code.stk.client.ui.base.column;

import java.util.Arrays;
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

public class EnumSelectionCell<E extends Enum<E>> extends
		AbstractInputCell<E, String> {

	private final List<E> options;

	interface Template extends SafeHtmlTemplates {
		@Template("<option value=\"{0}\">{0}</option>")
		SafeHtml deselected(String option);

		@Template("<option value=\"{0}\" selected=\"selected\">{0}</option>")
		SafeHtml selected(String option);
	}

	private static Template template;

	private HashMap<E, Integer> indexForOption = new HashMap<E, Integer>();

	public EnumSelectionCell(Class<E> clazz) {
		super("change");
		if (template == null) {
			template = GWT.create(Template.class);
		}

		this.options = Arrays.asList(clazz.getEnumConstants());
		int index = 0;
		for (E option : options) {
			indexForOption.put(option, index++);
		}
	}


	@Override
	public void onBrowserEvent(Context context, Element parent, E value, NativeEvent event,ValueUpdater<E> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		String type = event.getType();
		if ("change".equals(type)) {
			SelectElement select = parent.getFirstChild().cast();
			E newValue = options.get(select.getSelectedIndex());
			setViewData(context.getKey(), newValue.name());
			finishEditing(parent, newValue, context.getKey(), valueUpdater);
			if (valueUpdater != null) {
				valueUpdater.update(newValue);
			}
		}
	}

	private int getSelectedIndex(E value) {
		Integer index = indexForOption.get(value);
		if (index == null) {
			return -1;
		}
		return index.intValue();
	}

	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context,E value, SafeHtmlBuilder sb) {
		String viewData = getViewData(context.getKey());
		if (viewData != null && viewData.equals(value)) {
			clearViewData(context.getKey());
			viewData = null;
		}

		int selectedIndex = getSelectedIndex(value);
		sb.appendHtmlConstant("<select tabindex=\"-1\">");
		int index = 0;
		for (E option : options) {
			if (index++ == selectedIndex) {
				sb.append(template.selected(option.name()));
			} else {
				sb.append(template.deselected(option.name()));
			}
		}
		sb.appendHtmlConstant("</select>");

	}

}
