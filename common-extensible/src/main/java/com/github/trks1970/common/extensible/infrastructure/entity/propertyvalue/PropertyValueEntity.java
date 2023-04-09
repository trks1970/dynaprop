package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.NamedEntity;
import java.io.Serializable;

public interface PropertyValueEntity<
        ID extends Serializable,
        ET extends ExtensibleTypeEntity<ID>,
        E extends ExtensibleEntity<ID, ET>,
        PT extends PropertyTypeEntity<ID, ET>>
    extends NamedEntity<ID> {
  Object getValueObject();

  PT getPropertyType();

  PropertyValueEntity<ID, ET, E, PT> propertyType(PT propertyType);

  E getExtensible();

  PropertyValueEntity<ID, ET, E, PT> extensible(E extensible);
}
