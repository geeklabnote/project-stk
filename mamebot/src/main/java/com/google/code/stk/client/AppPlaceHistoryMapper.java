package com.google.code.stk.client;

import com.google.code.stk.client.ui.place.EditPlace;
import com.google.code.stk.client.ui.place.ListPlace;
import com.google.code.stk.client.ui.place.NewPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ListPlace.Tokenizer.class , EditPlace.Tokenizer.class , NewPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
