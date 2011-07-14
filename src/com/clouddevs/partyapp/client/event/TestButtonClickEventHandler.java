package com.clouddevs.partyapp.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface TestButtonClickEventHandler extends EventHandler {
  void onClick(TestButtonClickedEvent clickEvent);
}
