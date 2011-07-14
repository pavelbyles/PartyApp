package com.clouddevs.partyapp.server.domain;

import java.util.List;

import javax.jdo.annotations.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Person {
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String fname;
  private String lname;
  private String address;
  private String city;
  private String country;
  private String email;
  private String phoneNumber;
  
  public Person () {}
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getFname() {
    return fname;
  }
  public void setFname(String fname) {
    this.fname = fname;
  }
  
  public String getLname() {
    return lname;
  }
  public void setLname(String lname) {
    this.lname = lname;
  }
  
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public static List<Person> getAllPersons() {
    EntityManager em = entityManager();
    try {
      @SuppressWarnings("unchecked")
      List<Person> list = 
          em.createQuery("SELECT p FROM Person p").getResultList();
      list.size();
      return list;
    } finally {
      em.close();
    }
  }
  
  public static final EntityManager entityManager() {
    return EMF.get().createEntityManager();
  }
}