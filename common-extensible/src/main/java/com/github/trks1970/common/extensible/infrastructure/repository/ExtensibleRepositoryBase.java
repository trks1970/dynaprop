package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.Extensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.PropertyValue;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.PropertyValueEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.PersistentEntityRepositoryBase;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;

public abstract class ExtensibleRepositoryBase<
        ID extends Serializable,
        PV extends PropertyValue<ID>,
        E extends Extensible<ID>,
        ETE extends ExtensibleTypeEntity<ID>,
        PTE extends PropertyTypeEntity<ID, ETE>,
        EE extends ExtensibleEntity<ID, ETE>,
        PVE extends PropertyValueEntity<ID, ETE, EE, PTE>>
    extends PersistentEntityRepositoryBase<ID, E, EE> implements ExtensibleRepository<ID, PV, E> {

  @Override
  public Set<PV> getPropertyValues(ID extensibleId) {
    return propertyValueEntityRepository()
        .findBy(
            forExtensibleId(extensibleId),
            fetchableFluentQuery -> fetchableFluentQuery.project(getQueryAttributes()))
        .all()
        .stream()
        .map(pve -> propertyValueEntityMapper().toDomain(pve))
        .collect(Collectors.toSet());
  }

  protected abstract JpaBaseRepository<PVE, ID, Long> propertyValueEntityRepository();

  protected abstract Specification<PVE> forExtensibleId(ID extensibleId);

  protected abstract EntityMapper<ID, PV, PVE> propertyValueEntityMapper();

  protected abstract Collection<String> getQueryAttributes();
}
