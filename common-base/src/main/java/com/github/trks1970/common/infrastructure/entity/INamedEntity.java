package com.github.trks1970.common.infrastructure.entity;

import java.io.Serializable;

public interface INamedEntity<ID extends Serializable> extends IPersistentEntity<ID> {

  String getName();

  String getDescription();
}
