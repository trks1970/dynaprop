package com.github.trks1970.common.extensible.domain.model.propertytype;

import java.io.Serializable;

public interface BooleanProperty<ID extends Serializable> extends PropertyType<ID> {

  @Override
  default PropertyTypes getType() {
    return PropertyTypes.BOOLEAN;
  }
}
