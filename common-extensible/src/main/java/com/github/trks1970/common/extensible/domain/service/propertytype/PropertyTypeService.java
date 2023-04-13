package com.github.trks1970.common.extensible.domain.service.propertytype;

import com.github.trks1970.common.domain.service.NamedTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import java.io.Serializable;
import java.util.Set;

public interface PropertyTypeService<ID extends Serializable, PT extends IPropertyType<ID>>
    extends NamedTypeService<ID, PT> {
  Set<PT> getPropertyTypesOf(IExtensibleType<ID> extensibleType);

  Set<PT> getPropertyTypesOfExtensibleType(ID extensibleTypeId);
}
