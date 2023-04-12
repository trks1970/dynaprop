package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.domain.service.NamedTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import java.io.Serializable;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public interface ExtensibleTypeService<
        ID extends Serializable, PT extends IPropertyType<ID>, ET extends IExtensibleType<ID>>
    extends NamedTypeService<ID, ET> {

  PropertyTypeRepository<ID, PT> propertyTypeRepository();

  @Transactional
  default Set<PT> getPropertyTypes(ID extensibleTypeId) {
    return propertyTypeRepository().getPropertyTypes(extensibleTypeId);
  }

  @Transactional
  default PT addPropertyType(PT propertyType) {
    return propertyTypeRepository().save(propertyType);
  }

  @Transactional
  default void removePropertyType(PT propertyType) {
    propertyTypeRepository().deleteById(propertyType.getId());
  }
}
