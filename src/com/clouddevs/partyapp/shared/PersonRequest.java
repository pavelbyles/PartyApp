package com.clouddevs.partyapp.shared;

import java.util.List;

import com.clouddevs.partyapp.server.domain.Person;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Person.class)
public interface PersonRequest extends RequestContext {
  Request<List<PersonProxy>> getAllPersons();
}
