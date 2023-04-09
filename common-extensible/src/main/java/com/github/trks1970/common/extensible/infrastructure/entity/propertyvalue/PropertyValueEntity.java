package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.NamedEntity;
import java.io.Serializable;

public interface PropertyValueEntity<ID extends Serializable> extends NamedEntity<ID> {
  Object getValueObject();

  PropertyTypeEntity<ID> getPropertyType();

  void setPropertyType(PropertyTypeEntity<ID> propertyTypeEntity);
}
