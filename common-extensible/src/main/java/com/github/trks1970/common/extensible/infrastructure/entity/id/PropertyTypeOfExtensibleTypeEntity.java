package com.github.trks1970.common.extensible.infrastructure.entity.id;

import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import java.io.Serializable;
import org.springframework.lang.Nullable;

public interface PropertyTypeOfExtensibleTypeEntity<
    ID extends Serializable,
    P extends PropertyTypeEntity<ID>,
    T extends ExtensibleTypeEntity<ID, P>> {
  EmbeddedPropertyTypeOfExtensibleTypeId<ID> getId();

  P getPropertyType();

  void setPropertyType(@Nullable P propertyType);

  T getExtensibleType();

  void setExtensibleType(@Nullable T extensibleType);
}