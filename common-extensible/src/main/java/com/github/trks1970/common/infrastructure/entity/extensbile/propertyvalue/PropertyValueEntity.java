package com.github.trks1970.common.infrastructure.entity.extensbile.propertyvalue;

import com.github.trks1970.common.infrastructure.entity.NamedEntity;
import com.github.trks1970.common.infrastructure.entity.extensbile.propertytype.PropertyTypeEntity;
import java.io.Serializable;

public interface PropertyValueEntity<ID extends Serializable> extends NamedEntity<ID> {
  Object getValueObject();

  PropertyTypeEntity<ID> getPropertyType();

  void setPropertyType(PropertyTypeEntity<ID> propertyTypeEntity);
}
