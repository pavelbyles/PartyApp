package com.clouddevs.partyapp.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.clouddevs.partyapp.client.place.MainPlace;

@WithTokenizers({ MainPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}