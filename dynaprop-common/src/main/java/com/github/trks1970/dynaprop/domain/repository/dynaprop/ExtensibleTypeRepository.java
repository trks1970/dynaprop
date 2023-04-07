package com.github.trks1970.dynaprop.domain.repository.dynaprop;

import com.github.trks1970.dynaprop.domain.model.dynaprop.ExtensibleType;
import com.github.trks1970.dynaprop.domain.repository.NamedTypeRepository;

public interface ExtensibleTypeRepository<T extends ExtensibleType> extends NamedTypeRepository<T> {
  T addPropertyType(Long extensibleTypeId, Long propertyTypeId);
  T removePropertyType(Long extensibleTypeId, Long propertyTypeId);
}
