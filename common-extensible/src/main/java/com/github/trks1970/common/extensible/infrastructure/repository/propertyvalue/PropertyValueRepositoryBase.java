package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.io.Serializable;

public abstract class PropertyValueRepositoryBase<
        ID extends Serializable,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>,
        VT extends IPropertyValue<ID>,
        PTE extends IPropertyTypeEntity<ID, ETE>,
        VE extends IPropertyValueEntity<ID, ETE, EE, PTE>>
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
                    .setExtensible(
                        extensibleEntityRepository()
                            .findById(extensibleId)
                            .orElseThrow(() -> notFoundException(extensibleId, null, null))));
  }
}
