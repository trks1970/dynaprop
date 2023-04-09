package com.github.trks1970.common.infrastructure.entity.extensbile;

import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import com.github.trks1970.common.infrastructure.entity.extensbile.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.extensbile.propertyvalue.PropertyValueEntity;
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
