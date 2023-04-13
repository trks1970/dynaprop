package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.Types;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import java.io.Serializable;

public interface IPropertyValueEntity<
        ID extends Serializable,
        PTE extends IPropertyTypeEntity<ID>,
        ETE extends IExtensibleTypeEntity<ID, PTE>,
        EE extends IExtensibleEntity<ID, PTE, ETE>>
    extends INamedEntity<ID> {

  Object getValueObject();

  PTE getPropertyType();

  IPropertyValueEntity<ID, PTE, ETE, EE> setPropertyType(PTE propertyType);

  EE getExtensible();

  IPropertyValueEntity<ID, PTE, ETE, EE> setExtensible(EE extensible);

  Types getType();
}
