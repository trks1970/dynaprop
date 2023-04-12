package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.Types;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import java.io.Serializable;

public interface IPropertyValueEntity<
        ID extends Serializable,
        ET extends IExtensibleTypeEntity<ID>,
        E extends IExtensibleEntity<ID, ET>,
        PT extends IPropertyTypeEntity<ID, ET>>
    extends INamedEntity<ID> {
  Object getValueObject();

  PT getPropertyType();

  IPropertyValueEntity<ID, ET, E, PT> setPropertyType(PT propertyType);

  E getExtensible();

  IPropertyValueEntity<ID, ET, E, PT> setExtensible(E extensible);

  Types getType();
}
