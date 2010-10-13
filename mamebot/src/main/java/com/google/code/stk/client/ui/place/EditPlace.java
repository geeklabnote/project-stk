package com.google.code.stk.client.ui.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EditPlace extends Place {

	private final long id;

	public EditPlace(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public static class Tokenizer implements PlaceTokenizer<EditPlace>{

		@Override
		public EditPlace getPlace(String token) {
			return new EditPlace(Long.parseLong(token));
		}

		@Override
		public String getToken(EditPlace place) {
			return String.valueOf(place.getId());
		}

	}

}
