package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.PropertyValueEntity;
import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import java.io.Serializable;
import java.util.Set;

public interface ExtensibleEntity<
        ID extends Serializable,
        P extends PropertyTypeEntity<ID>,
        T extends ExtensibleTypeEntity<ID, P>,
        V extends PropertyValueEntity<ID>>
    extends PersistentEntity<ID> {

  T getExtensibleType();

  void setExtensibleType(T type);

  Set<V> getPropertyValues();
}
