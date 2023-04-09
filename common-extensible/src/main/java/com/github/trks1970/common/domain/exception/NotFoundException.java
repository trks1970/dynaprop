package com.github.trks1970.common.domain.exception;

public class NotFoundException extends DomainException {
  public NotFoundException(Class<?> type, String lookup) {
    super(type.getSimpleName() + " not found by " + lookup);
  }
}
