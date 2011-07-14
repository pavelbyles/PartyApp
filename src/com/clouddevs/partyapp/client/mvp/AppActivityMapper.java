package com.clouddevs.partyapp.client.mvp;

import com.clouddevs.partyapp.client.ClientFactory;
import com.clouddevs.partyapp.client.activity.MainActivity;
import com.clouddevs.partyapp.client.place.MainPlace;
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
    // This is begging for GIN
    if (place instanceof MainPlace) {
      return new MainActivity(clientFactory);
    }
    return null;
  }

}
