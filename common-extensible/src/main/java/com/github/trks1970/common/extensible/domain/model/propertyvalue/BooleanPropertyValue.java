package com.github.trks1970.common.extensible.domain.model.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyTypes;
import java.io.Serializable;

public interface BooleanPropertyValue<ID extends Serializable> extends PropertyValue<ID> {
  @Override
  default PropertyTypes getType() {
    return PropertyTypes.BOOLEAN;
  }
}
