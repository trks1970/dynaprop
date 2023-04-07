package com.github.trks1970.dynaprop.infrastructure.entity.dynaprop;

import com.github.trks1970.dynaprop.infrastructure.entity.PersistentEntity;

import java.util.Set;

public interface ExtensibleEntity<
  T extends ExtensibleTypeEntity,
  V extends PropertyValueEntity>
  extends PersistentEntity {

  T getExtensibleType();
  void setExtensibleType(T type);

  Set<V> getPropertyValues();

}
