package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
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
        PV extends IPropertyValue<ID>,
        E extends IExtensible<ID>,
        ETE extends IExtensibleTypeEntity<ID>,
        PTE extends IPropertyTypeEntity<ID, ETE>,
        EE extends IExtensibleEntity<ID, ETE>,
        PVE extends IPropertyValueEntity<ID, ETE, EE, PTE>>
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
