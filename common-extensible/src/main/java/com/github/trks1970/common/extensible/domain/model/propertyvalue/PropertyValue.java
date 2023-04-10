package com.github.trks1970.common.extensible.domain.model.propertyvalue;

import com.github.trks1970.common.domain.model.Named;
import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyTypes;
import java.io.Serializable;

public interface PropertyValue<ID extends Serializable> extends Named<ID> {
  Object getValueObject();

  ID getPropertyTypeId();

  ID getExtensibleId();

  PropertyTypes getType();
}
