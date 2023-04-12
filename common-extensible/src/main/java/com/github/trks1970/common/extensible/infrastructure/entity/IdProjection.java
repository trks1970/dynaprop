package com.github.trks1970.common.extensible.infrastructure.entity;

import java.io.Serializable;

public interface IdProjection<ID extends Serializable> {
  ID getId();

  void setId(ID id);
}
