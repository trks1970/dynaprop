package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.io.Serializable;

public interface IExtensibleEntity<
        ID extends Serializable,
        PTE extends IPropertyTypeEntity<ID>,
        ETE extends IExtensibleTypeEntity<ID, PTE>>
    extends IPersistentEntity<ID> {

  ETE getExtensibleType();

  void setExtensibleType(ETE extensibleType);
}
