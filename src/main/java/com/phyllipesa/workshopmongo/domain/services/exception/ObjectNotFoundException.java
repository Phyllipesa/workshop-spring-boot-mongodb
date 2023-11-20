package com.phyllipesa.workshopmongo.domain.services.exception;

public class ObjectNotFoundException extends RuntimeException {

  public ObjectNotFoundException (String msg) {
    super(msg);
  }
}
