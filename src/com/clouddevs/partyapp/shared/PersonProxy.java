package com.clouddevs.partyapp.shared;

import java.util.List;

import com.clouddevs.partyapp.server.domain.Person;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Person.class)
public interface PersonProxy extends EntityProxy {
  String getFname();
  String getLname();
  List<PersonProxy> getAllPersons();
}