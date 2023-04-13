package com.github.trks1970.common.extensible.domain.service.propertytype.impl;

import com.github.trks1970.common.domain.service.impl.AbstractNamedTypeService;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.service.propertytype.PropertyTypeService;
import java.io.Serializable;

public abstract class AbstractPropertyTypeService<ID extends Serializable>
    extends AbstractNamedTypeService<ID, IPropertyType<ID>>
    implements PropertyTypeService<ID, IPropertyType<ID>> {}
