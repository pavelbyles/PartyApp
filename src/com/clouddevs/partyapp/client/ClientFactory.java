package com.clouddevs.partyapp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.clouddevs.partyapp.client.ui.MainView;

public interface ClientFactory {
  EventBus getEventBus();
  PlaceController getPlaceController();
  MainView getMainView();
}
