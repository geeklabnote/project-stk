package com.google.code.stk.client;

import com.google.code.stk.client.place.EditPlace;
import com.google.code.stk.client.place.ListPlace;
import com.google.code.stk.client.place.NewPlace;
import com.google.code.stk.client.presenter.EditPresenter;
import com.google.code.stk.client.presenter.ListPresenter;
import com.google.code.stk.client.presenter.NewPresenter;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if(place instanceof ListPlace){
			return new ListPresenter((ListPlace)place, clientFactory);
		}

		if(place instanceof NewPlace){
			return new NewPresenter((NewPlace)place ,  clientFactory);
		}

		if(place instanceof EditPlace){
			return new EditPresenter((EditPlace)place, clientFactory);
		}

		return null;
	}

}
