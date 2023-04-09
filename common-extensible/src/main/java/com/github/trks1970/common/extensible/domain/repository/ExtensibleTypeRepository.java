package com.github.trks1970.common.extensible.domain.repository;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.ExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyType;
import java.io.Serializable;
import java.util.Set;

public interface ExtensibleTypeRepository<
        ID extends Serializable, P extends PropertyType<ID>, T extends ExtensibleType<ID>>
    extends NamedTypeRepository<ID, T> {

  Set<P> getPropertyTypesOf(ID extensibleTypeId);

  @Override
  void deleteById(ID extensibleTypeId);
}
