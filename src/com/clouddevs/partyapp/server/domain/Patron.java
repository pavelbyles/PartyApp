package com.clouddevs.partyapp.server.domain;

import java.util.List;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patron {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  private List<String> musicType;
  private List<String> partyCategory;
  private String password;
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public List<String> getMusicType() {
    return musicType;
  }
  public void setMusicType(List<String> musicType) {
    this.musicType = musicType;
  }
  public List<String> getPartyCategory() {
    return partyCategory;
  }
  public void setPartyCategory(List<String> partyCategory) {
    this.partyCategory = partyCategory;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
