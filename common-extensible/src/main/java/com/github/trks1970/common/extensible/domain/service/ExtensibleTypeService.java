package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.domain.service.NamedTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import java.io.Serializable;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public interface ExtensibleTypeService<
        ID extends Serializable, PT extends IPropertyType<ID>, ET extends IExtensibleType<ID>>
    extends NamedTypeService<ID, ET> {

  @Transactional
  PT addPropertyType(ID extensibleTypeId, PT propertyType);

  @Transactional
  PT removePropertyType(ID extensibleTypeId, PT propertyType);

  @Transactional
  Set<PT> getPropertyTypes(ID extensibleTypeId);
}
