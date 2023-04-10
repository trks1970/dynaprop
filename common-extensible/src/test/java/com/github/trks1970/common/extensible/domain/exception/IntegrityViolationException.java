package com.github.trks1970.common.extensible.domain.exception;

import com.github.trks1970.common.domain.exception.DomainException;

public class IntegrityViolationException extends DomainException {

  public IntegrityViolationException(String message) {
    super(message);
  }
}
