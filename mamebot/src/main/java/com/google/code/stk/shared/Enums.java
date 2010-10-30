package com.google.code.stk.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;

public class Enums {

	public static enum Cycle {
		DAY, MONTH, WEEK , AT;
	}

	public static enum Bure{
		FIX,RANDOM;
	}

	public static List<String> names(Class<? extends Enum<?>> e){
		List<String> names = new ArrayList<String>();
		for (Enum<?> enumn : e.getEnumConstants()) {
			names.add(enumn.name());
		}
		return names;
	}

	public static <T extends Enum<?>> Renderer<T> getEnumRenderer(){
		return new AbstractRenderer<T>() {

			@Override
			public String render(T object) {
				return object== null?null:object.name();
			}
		};
	}
}
