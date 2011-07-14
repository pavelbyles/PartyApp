package com.clouddevs.partyapp.server.domain;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gwt.maps.client.geom.LatLng;


@Entity
public class Country {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  private String name;
  private LatLng coordinates;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public LatLng getCoordinates() {
    return coordinates;
  }
  public void setCoordinates(LatLng coordinates) {
    this.coordinates = coordinates;
  }
}
