package com.clouddevs.partyapp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MainViewImpl extends Composite implements MainView {

  private static MainViewImplUiBinder uiBinder = GWT
      .create(MainViewImplUiBinder.class);
  
  private Presenter listener;

  interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
  }

  public MainViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiField
  Button testButton;
  @UiField
  Label testLabel;

  public MainViewImpl(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
    testButton.setText(firstName);
  }

  @UiHandler("testButton")
  void onClick(ClickEvent e) {
    if (null != listener) {
      listener.onClick();
    }
  }

  @Override
  public void setPresenter(Presenter listener) {
    this.listener = listener;
  }

  @Override
  public Label getTestLabel() {
    return testLabel;
  }
}
