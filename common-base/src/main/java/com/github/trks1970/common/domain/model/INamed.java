package com.github.trks1970.common.domain.model;

import java.io.Serializable;

public interface INamed<ID extends Serializable> extends IPersistent<ID> {
  String getName();

  String getDescription();
}
