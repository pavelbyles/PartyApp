package com.clouddevs.partyapp.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface MainView extends IsWidget {
  void setPresenter(Presenter listener);
  
  Label getTestLabel();

  public interface Presenter {
    void goTo(Place place);
    void onClick();
  }
}
