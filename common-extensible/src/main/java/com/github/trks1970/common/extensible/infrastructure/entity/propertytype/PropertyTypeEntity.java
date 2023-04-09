package com.github.trks1970.common.extensible.infrastructure.entity.propertytype;

import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.entity.NamedEntity;
import java.io.Serializable;

public interface PropertyTypeEntity<ID extends Serializable, E extends ExtensibleTypeEntity<ID>>
    extends NamedEntity<ID> {
  E getExtensibleType();

  PropertyTypeEntity<ID, E> setExtensibleType(E extensibleType);
}
