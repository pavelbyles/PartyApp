package com.clouddevs.partyapp.client.activity;

import java.util.List;

import com.clouddevs.partyapp.client.ClientFactory;
import com.clouddevs.partyapp.client.event.TestButtonClickEventHandler;
import com.clouddevs.partyapp.client.event.TestButtonClickedEvent;
import com.clouddevs.partyapp.client.ui.MainView;
import com.clouddevs.partyapp.shared.PersonProxy;
import com.clouddevs.partyapp.shared.PersonRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class MainActivity extends AbstractActivity implements 
    MainView.Presenter {

  private ClientFactory clientFactory;
  private MainView mainView;
  private EventBus eventBus = null;
  
  public MainActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }
  
  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    this.eventBus = eventBus;
    mainView = clientFactory.getMainView();

    mainView.setPresenter(this);

    panel.setWidget(mainView.asWidget());
    
    bindHandlers();
  }
  
  private void bindHandlers() {
    eventBus.addHandler(TestButtonClickedEvent.TYPE, new TestButtonClickEventHandler() {
      
      @Override
      public void onClick(TestButtonClickedEvent clickEvent) {
        mainView.getTestLabel().setText("World! ... getting some data now");
        GetAllPersonsFromDataStore();
      }
    });
  }
  
  private void DisplayPersons(List<PersonProxy> persons) {
    CellTable<PersonProxy> cellTable = new CellTable<PersonProxy>();
    Column<PersonProxy, String> fnameCol = new Column<PersonProxy, String>(new EditTextCell()) {
      
      @Override
      public String getValue(PersonProxy object) {
        return object.getFname();
      }
    };
    
    Column<PersonProxy, String> lnameCol = new Column<PersonProxy, String>(new EditTextCell()) {
      
      @Override
      public String getValue(PersonProxy object) {
        return object.getLname();
      }
    };
    
    fnameCol.setSortable(true);
    lnameCol.setSortable(true);
    
    TextCell textCell = new TextCell();
    cellTable.addColumn(fnameCol, "First Name");
    cellTable.addColumn(lnameCol, "Last Name");
    CellList<String> fnameCellList = new CellList<String>(textCell); 
    fnameCellList.setRowCount(persons.size(), true);
    cellTable.setRowData(0, persons);
    
    //mainView.getGridContainer().clear();
    //mainView.getGridContainer().add(cellTable);
  }
  
  private void GetAllPersonsFromDataStore() {
    PersonRequestFactory rf = GWT.create(PersonRequestFactory.class);
    rf.initialize(eventBus);
    rf.personRequest().getAllPersons().fire(new Receiver<List<PersonProxy>>() {

      @Override
      public void onSuccess(List<PersonProxy> response) {
        DisplayPersons(response);
      }
      
      @Override
      public void onFailure(ServerFailure failure) {
        mainView.getTestLabel().setText(failure.toString());
      }
    });
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

  @Override
  public void onClick() {
    eventBus.fireEvent(new TestButtonClickedEvent());
  }
}
