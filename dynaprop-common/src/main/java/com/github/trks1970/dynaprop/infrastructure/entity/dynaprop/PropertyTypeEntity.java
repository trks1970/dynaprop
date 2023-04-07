package com.github.trks1970.dynaprop.infrastructure.entity.dynaprop;

import com.github.trks1970.dynaprop.infrastructure.entity.NamedEntity;

import java.util.Set;

public interface PropertyTypeEntity extends NamedEntity {
  Set<PropertyTypeOfExtensibleTypeEntity<?, ?>> getExtensibleTypes();

}
