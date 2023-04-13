package com.github.trks1970.common.extensible.domain.repository.propertytype;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import java.io.Serializable;
import java.util.Set;

public interface PropertyTypeRepository<ID extends Serializable, PT extends IPropertyType<ID>>
    extends NamedTypeRepository<ID, PT> {
  Set<PT> getPropertyTypesOfExtensibleType(ID extensibleTypeId);
}
