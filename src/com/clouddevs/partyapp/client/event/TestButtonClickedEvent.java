package com.clouddevs.partyapp.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class TestButtonClickedEvent extends 
    GwtEvent<TestButtonClickEventHandler> {
  
  public static final GwtEvent.Type<TestButtonClickEventHandler> TYPE = 
      new GwtEvent.Type<TestButtonClickEventHandler>();
  private Throwable error;
  
  public TestButtonClickedEvent() {
  }
  
  @Override
  public GwtEvent.Type<TestButtonClickEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(TestButtonClickEventHandler handler) {
    handler.onClick(this);
  }
  
  public Throwable getError() {
    return error;
  }

  public void setError(Throwable error) {
    this.error = error;
  }

  public boolean isFailed() {
    return (error != null);
  }
}