package com.github.trks1970.common.extensible.domain.service.propertyvalue.impl;

import com.github.trks1970.common.domain.service.impl.AbstractNamedTypeService;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.service.propertyvalue.PropertyValueService;
import java.io.Serializable;

public abstract class AbstractPropertyValueService<ID extends Serializable>
    extends AbstractNamedTypeService<ID, IPropertyValue<ID>>
    implements PropertyValueService<ID, IPropertyValue<ID>> {}
