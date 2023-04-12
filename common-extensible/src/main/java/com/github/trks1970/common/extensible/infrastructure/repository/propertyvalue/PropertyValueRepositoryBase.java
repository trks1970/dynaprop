package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;

public abstract class PropertyValueRepositoryBase<
        ID extends Serializable,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>,
        VT extends IPropertyValue<ID>,
        PTE extends IPropertyTypeEntity<ID, ETE>,
        PVE extends IPropertyValueEntity<ID, ETE, EE, PTE>>
    extends NamedEntityRepositoryBase<ID, VT, PVE> implements PropertyValueRepository<ID, VT> {

  protected abstract Specification<PVE> extensibleId(ID extensibleId);

  @Override
  public Set<VT> getPropertyValues(ID extensibleId) {
    return repository().findAll(extensibleId(extensibleId)).stream()
        .map(pte -> mapper().toDomain(pte))
        .collect(Collectors.toSet());
  }
}
