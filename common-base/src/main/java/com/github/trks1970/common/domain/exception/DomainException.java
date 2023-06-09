package com.github.trks1970.common.domain.exception;

public abstract class DomainException extends RuntimeException {
  protected DomainException(String message) {
    super(message);
  }

  protected DomainException(String message, Throwable cause) {
    super(message, cause);
  }

  protected DomainException(Throwable cause) {
    super(cause);
  }
}
