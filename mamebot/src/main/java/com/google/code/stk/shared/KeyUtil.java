package com.google.code.stk.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;

public class KeyUtil {

	public static final Renderer<Key> KEY_NAME_RENDERER = new AbstractRenderer<Key>() {

		@Override
		public String render(Key object) {
			return object==null?null:object.getName();
		}
	};

	public static List<String> getKeyNames(List<Key> keys){
		List<String> names = new ArrayList<String>();

		for (Key key : keys) {
			names.add(key.getName());
		}

		return names;
	}
}
