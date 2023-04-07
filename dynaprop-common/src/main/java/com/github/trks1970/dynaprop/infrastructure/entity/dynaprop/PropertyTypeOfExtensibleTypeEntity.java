package com.github.trks1970.dynaprop.infrastructure.entity.dynaprop;

import com.github.trks1970.dynaprop.infrastructure.entity.dynaprop.id.EmbeddedPropertyTypeOfExtensibleTypeId;
import org.springframework.lang.Nullable;

public interface PropertyTypeOfExtensibleTypeEntity<
  T extends ExtensibleTypeEntity<P>,
  P extends PropertyTypeEntity> {
  EmbeddedPropertyTypeOfExtensibleTypeId getId();
  P getPropertyType();
  void setPropertyType(@Nullable P propertyType);
  T getExtensibleType();
  void setExtensibleType(@Nullable T extensibleType);
}

