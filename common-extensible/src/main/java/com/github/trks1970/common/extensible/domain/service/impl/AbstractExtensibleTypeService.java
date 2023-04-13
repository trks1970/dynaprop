package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.service.impl.AbstractNamedTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.domain.service.ExtensibleTypeService;
import com.github.trks1970.common.extensible.domain.service.propertytype.PropertyTypeService;
import java.io.Serializable;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractExtensibleTypeService<
        ID extends Serializable, PT extends IPropertyType<ID>, ET extends IExtensibleType<ID>>
    extends AbstractNamedTypeService<ID, ET> implements ExtensibleTypeService<ID, PT, ET> {

  @Override
  protected abstract ExtensibleTypeRepository<ID, PT, ET> repository();

  protected abstract PropertyTypeService<ID, PT> propertyTypeService();

  @Override
  @Transactional
  public PT addPropertyType(ID extensibleTypeId, PT propertyType) {
    return repository().addPropertyType(extensibleTypeId, propertyType);
  }

  @Override
  @Transactional
  public PT removePropertyType(ID extensibleTypeId, PT propertyType) {
    return repository().removePropertyType(extensibleTypeId, propertyType);
  }

  @Override
  @Transactional
  public Set<PT> getPropertyTypes(ID extensibleTypeId) {
    return propertyTypeService().getPropertyTypesOfExtensibleType(extensibleTypeId);
  }
}
