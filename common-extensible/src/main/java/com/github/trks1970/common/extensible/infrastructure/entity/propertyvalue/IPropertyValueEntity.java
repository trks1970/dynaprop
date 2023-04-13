package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.Types;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import java.io.Serializable;

public interface IPropertyValueEntity<
        ID extends Serializable,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>,
        PTE extends IPropertyTypeEntity<ID, ETE>>
    extends INamedEntity<ID> {
  Object getValueObject();

  PTE getPropertyType();

  IPropertyValueEntity<ID, ETE, EE, PTE> setPropertyType(PTE propertyType);

  EE getExtensible();

  IPropertyValueEntity<ID, ETE, EE, PTE> setExtensible(EE extensible);

  Types getType();
}
