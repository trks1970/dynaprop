package com.github.trks1970.common.infrastructure.entity;

import java.io.Serializable;

public interface NamedEntity<ID extends Serializable> extends PersistentEntity<ID> {
  String getName();

  String getDescription();
}
