package com.clouddevs.partyapp.client;

import com.clouddevs.partyapp.client.mvp.AppActivityMapper;
import com.clouddevs.partyapp.client.mvp.AppPlaceHistoryMapper;
import com.clouddevs.partyapp.client.place.MainPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PartyApp implements EntryPoint {
  
  private Place defaultPlace = new MainPlace("MainPlace!");
  private SimplePanel appWidget = new SimplePanel();
  
	public void onModuleLoad() {
	  ClientFactory clientFactory = GWT.create(ClientFactory.class);
    EventBus eventBus = clientFactory.getEventBus();
    PlaceController placeController = clientFactory.getPlaceController();

    ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
    ActivityManager activityManager = new ActivityManager(activityMapper,
        eventBus);
    activityManager.setDisplay(appWidget);

    AppPlaceHistoryMapper historyMapper = 
        GWT.create(AppPlaceHistoryMapper.class);
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    RootLayoutPanel.get().add(appWidget);

    historyHandler.handleCurrentHistory();
	}
}
