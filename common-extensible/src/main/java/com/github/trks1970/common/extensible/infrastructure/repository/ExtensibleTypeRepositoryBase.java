package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.ExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.PropertyValueEntity;
import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class ExtensibleTypeRepositoryBase<
        ID extends Serializable,
        ET extends ExtensibleType<ID>,
        PT extends PropertyType<ID>,
        ETE extends ExtensibleTypeEntity<ID>,
        EE extends ExtensibleEntity<ID, ETE>,
        PTE extends PropertyTypeEntity<ID, ETE>,
        PVE extends PropertyValueEntity<ID, ETE, EE, PTE>>
    extends NamedEntityRepositoryBase<ID, ET, ETE> implements ExtensibleTypeRepository<ID, PT, ET> {

  protected abstract JpaBaseRepository<PTE, ID, Long> propertyTypeEntityRepository();

  protected abstract JpaBaseRepository<PVE, ID, Long> propertyValueEntityRepository();

  protected abstract Specification<PTE> extensibleType(ID extensibleTypeId);

  protected abstract Specification<PVE> propertyTypes(Set<ID> propertyTypeIds);

  protected abstract EntityMapper<ID, PT, PTE> propertyTypeMapper();

  protected abstract String getIdPropertyName();

  @Override
  public Set<PT> getPropertyTypesOf(ID extensibleTypeId) {
    return propertyTypeEntityRepository().findAll(extensibleType(extensibleTypeId)).stream()
        .map(propertyType -> propertyTypeMapper().toDomain(propertyType))
        .collect(Collectors.toSet());
  }

  @Override
  public void deleteById(ID extensibleTypeId) {
    Set<ID> propertyTypeIds =
        propertyTypeEntityRepository()
            .findBy(
                extensibleType(extensibleTypeId),
                fetchableFluentQuery -> fetchableFluentQuery.project(getIdPropertyName()))
            .all()
            .stream()
            .map(PersistentEntity::getId)
            .collect(Collectors.toSet());
    propertyValueEntityRepository().delete(propertyTypes(propertyTypeIds));
    propertyTypeEntityRepository().deleteAllById(propertyTypeIds);
    repository().deleteById(extensibleTypeId);
  }
}
