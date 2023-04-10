package com.github.trks1970.common.extensible.domain.service.propertytype;

import com.github.trks1970.common.domain.service.NamedTypeService;
import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyType;
import java.io.Serializable;

public interface PropertyTypeService<ID extends Serializable, PT extends PropertyType<ID>>
    extends NamedTypeService<ID, PT> {}
