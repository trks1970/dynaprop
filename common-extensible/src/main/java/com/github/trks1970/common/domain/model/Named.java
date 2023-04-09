package com.github.trks1970.common.domain.model;

import java.io.Serializable;

public interface Named<ID extends Serializable> extends Persistent<ID> {
  String getName();

  String getDescription();
}
