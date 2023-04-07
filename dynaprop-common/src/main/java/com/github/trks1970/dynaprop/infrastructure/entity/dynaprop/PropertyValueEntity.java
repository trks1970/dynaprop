package com.github.trks1970.dynaprop.infrastructure.entity.dynaprop;

import com.github.trks1970.dynaprop.infrastructure.entity.NamedEntity;

public interface PropertyValueEntity extends NamedEntity {
  Object getValueObject();
  PropertyTypeEntity getPropertyType();
  void setPropertyType(PropertyTypeEntity propertyTypeEntity);
}
