package com.google.code.stk.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class NewPlace extends Place {

	
	
	public static class Tokenizer implements PlaceTokenizer<NewPlace>{

		@Override
		public NewPlace getPlace(String token) {
			return new NewPlace();
		}

		@Override
		public String getToken(NewPlace place) {
			return "";
		}

	}
}
