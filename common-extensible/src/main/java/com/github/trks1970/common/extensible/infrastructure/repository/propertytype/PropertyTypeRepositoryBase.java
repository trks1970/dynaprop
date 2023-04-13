package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.JpaPropertyValueEntityRepository;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;

public abstract class PropertyTypeRepositoryBase<
        ID extends Serializable,
        PT extends IPropertyType<ID>,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>,
        PTE extends IPropertyTypeEntity<ID, ETE>,
        PVE extends IPropertyValueEntity<ID, ETE, EE, PTE>>
    extends NamedEntityRepositoryBase<ID, PT, PTE> implements PropertyTypeRepository<ID, PT> {

  protected abstract JpaPropertyValueEntityRepository<ID, ETE, EE, PTE, PVE>
      propertyValueRepository();

  protected abstract Specification<PTE> extensibleType(ID extensibleTypeId);

  @Override
  public Set<PT> getPropertyTypes(ID extensibleTypeId) {
    return repository().findAll(extensibleType(extensibleTypeId)).stream()
        .map(pte -> mapper().toDomain(pte))
        .collect(Collectors.toSet());
  }

  @Override
  public void deleteById(ID propertyTypeId) {
    propertyValueRepository()
        .findByPropertyTypeId(propertyTypeId)
        .forEach(
            propertyValue ->
                propertyValueRepository()
                    .deleteById(Objects.requireNonNull(propertyValue.getId())));
  }
}
