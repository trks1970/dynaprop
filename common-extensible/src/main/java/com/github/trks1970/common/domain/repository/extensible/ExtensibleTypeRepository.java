package com.github.trks1970.common.domain.repository.extensible;

import com.github.trks1970.common.domain.model.extensible.ExtensibleType;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import java.io.Serializable;

public interface ExtensibleTypeRepository<ID extends Serializable, T extends ExtensibleType<ID>>
    extends NamedTypeRepository<ID, T> {
  T addPropertyType(ID extensibleTypeId, ID propertyTypeId);

  T removePropertyType(ID extensibleTypeId, ID propertyTypeId);
}
