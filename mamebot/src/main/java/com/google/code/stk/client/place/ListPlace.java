package com.google.code.stk.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ListPlace extends Place {

	private final String state;
	private final Long id;

	public ListPlace(){
		this(null , null);
	}

	public ListPlace(String state, Long id) {
		this.state = state;
		this.id = id;
	}

	public ListPlace(String state) {
		this(state, null);
	}

	public Long getId() {
		return id;
	}

	public String getStringId(){
		return id == null?"":id.toString();
	}

	public String getState() {
		return state == null ? "" :state;
	}
	public static class Tokenizer implements PlaceTokenizer<ListPlace>{

		@Override
		public ListPlace getPlace(String token) {

			if(token.contains("delete")){
				return new ListPlace("delete" , Long.parseLong(token.replace("delete/", "")));
			}

			if(token.contains("edit")){
				return new ListPlace("edit" , Long.parseLong(token.replace("edit/", "")));
			}

			if(token.contains("new")){
				return new ListPlace("new");
			}

			return new ListPlace();
		}

		@Override
		public String getToken(ListPlace place) {
			return place.getState() + "/" + place.getStringId();
		}

	}
}
