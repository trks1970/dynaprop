package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import java.io.Serializable;
import java.util.Set;

public interface IExtensibleTypeEntity<ID extends Serializable, PTE extends IPropertyTypeEntity<ID>>
    extends INamedEntity<ID> {
  PTE addPropertyType(PTE propertyTypeEntity);

  PTE removePropertyType(PTE propertyTypeEntity);

  Set<PTE> getPropertyTypes();
}
