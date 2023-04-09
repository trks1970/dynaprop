package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.PropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.PropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.io.Serializable;

public abstract class PropertyValueRepositoryBase<
        ID extends Serializable,
        ETE extends ExtensibleTypeEntity<ID>,
        EE extends ExtensibleEntity<ID, ETE>,
        VT extends PropertyValue<ID>,
        PTE extends PropertyTypeEntity<ID, ETE>,
        VE extends PropertyValueEntity<ID, ETE, EE, PTE>>
    extends NamedEntityRepositoryBase<ID, VT, VE> implements PropertyValueRepository<ID, VT> {

  protected abstract JpaBaseRepository<EE, ID, Long> extensibleEntityRepository();

  @Override
  @SuppressWarnings("unchecked")
  public void addToExtensible(ID extensibleId, VT propertyValue) {
    repository()
        .save(
            (VE)
                mapper()
                    .toEntity(propertyValue)
                    .extensible(
                        extensibleEntityRepository()
                            .findById(extensibleId)
                            .orElseThrow(() -> notFoundException(extensibleId, null, null))));
  }
}
