package com.github.trks1970.common.extensible.domain.service.propertyvalue;

import com.github.trks1970.common.domain.service.NamedTypeService;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import java.io.Serializable;

public interface PropertyValueService<ID extends Serializable, PV extends IPropertyValue<ID>>
    extends NamedTypeService<ID, PV> {}
