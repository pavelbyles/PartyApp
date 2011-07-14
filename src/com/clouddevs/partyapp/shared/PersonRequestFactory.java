package com.clouddevs.partyapp.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface PersonRequestFactory extends RequestFactory {
  PersonRequest personRequest();
}
