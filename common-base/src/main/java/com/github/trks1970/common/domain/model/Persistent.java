package com.github.trks1970.common.domain.model;

public interface Persistent<ID> {
  ID getId();

  @SuppressWarnings("unchecked")
  default Class<Persistent<ID>> getPersistentClass() {
    return (Class<Persistent<ID>>) this.getClass();
  }
}
