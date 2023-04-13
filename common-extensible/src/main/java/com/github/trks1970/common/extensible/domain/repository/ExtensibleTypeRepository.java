package com.github.trks1970.common.extensible.domain.repository;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import java.io.Serializable;

public interface ExtensibleTypeRepository<
        ID extends Serializable, PT extends IPropertyType<ID>, ET extends IExtensibleType<ID>>
    extends NamedTypeRepository<ID, ET> {
  PT addPropertyType(ID extensibleTypeId, PT propertyType);

  PT removePropertyType(ID extensibleTypeId, PT propertyType);
}
