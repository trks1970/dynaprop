package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaPropertyTypeEntityRepository;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class PropertyTypeRepositoryBase<
        ID extends Serializable, PT extends IPropertyType<ID>, PTE extends IPropertyTypeEntity<ID>>
    extends NamedEntityRepositoryBase<ID, PT, PTE> implements PropertyTypeRepository<ID, PT> {

  @Override
  protected abstract JpaPropertyTypeEntityRepository<ID, PTE> repository();

  @Override
  public Set<PT> getPropertyTypesOfExtensibleType(ID extensibleTypeId) {
    return repository().findByExtensibleTypeId(extensibleTypeId).stream()
        .map(propertyType -> mapper().toDomain(propertyType))
        .collect(Collectors.toSet());
  }
}
