package com.clouddevs.partyapp.client;

import com.clouddevs.partyapp.client.ui.MainView;
import com.clouddevs.partyapp.client.ui.MainViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
  
  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(
      eventBus);
  private static final MainView mainView = new MainViewImpl();
  
  @Override
  public EventBus getEventBus() {
    return eventBus;
  }

  @Override
  public PlaceController getPlaceController() {
    return placeController;
  }

  @Override
  public MainView getMainView() {
    return mainView;
  }

}
