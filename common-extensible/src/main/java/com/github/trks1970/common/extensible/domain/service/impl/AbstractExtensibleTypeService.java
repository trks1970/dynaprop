package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.service.impl.AbstractNamedTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.domain.service.ExtensibleTypeService;
import java.io.Serializable;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractExtensibleTypeService<
        ID extends Serializable, PT extends IPropertyType<ID>, ET extends IExtensibleType<ID>>
    extends AbstractNamedTypeService<ID, ET> implements ExtensibleTypeService<ID, PT, ET> {

  protected abstract PropertyTypeRepository<ID, PT> propertyTypeRepository();

  @Transactional
  public Set<PT> getPropertyTypes(ID extensibleTypeId) {
    return propertyTypeRepository().getPropertyTypes(extensibleTypeId);
  }

  @Transactional
  public PT addPropertyType(PT propertyType) {
    return propertyTypeRepository().save(propertyType);
  }

  @Transactional
  public void removePropertyType(PT propertyType) {
    propertyTypeRepository().deleteById(propertyType.getId());
  }
}
