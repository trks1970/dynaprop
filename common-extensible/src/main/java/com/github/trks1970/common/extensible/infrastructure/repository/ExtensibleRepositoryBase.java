package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaPropertyTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.JpaPropertyValueEntityRepository;
import com.github.trks1970.common.infrastructure.repository.PersistentEntityRepositoryBase;
import java.io.Serializable;
import java.util.Objects;

public abstract class ExtensibleRepositoryBase<
        ID extends Serializable,
        E extends IExtensible<ID>,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>,
    PTE extends IPropertyTypeEntity<ID, ETE>,
    PVE extends IPropertyValueEntity<ID, ETE, EE, PTE>>
    extends PersistentEntityRepositoryBase<ID, E, EE> implements ExtensibleRepository<ID, E> {

  protected abstract JpaPropertyValueEntityRepository<ID, ETE, EE, PTE, PVE> propertyValueRepository();
  @Override
  public void deleteById(ID extensibleId) {
    // delete ExtensibleValues
    propertyValueRepository()
        .findByExtensibleId(extensibleId)
        .forEach(
            propertyValue ->
                propertyValueRepository().deleteById(Objects.requireNonNull(propertyValue.getId())));


  }
}
