package com.github.trks1970.common.domain.repository.extensible.propertyvalue;

import com.github.trks1970.common.domain.model.extensible.propertyvalue.PropertyValue;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import java.io.Serializable;

public interface PropertyValueRepository<ID extends Serializable, T extends PropertyValue<ID>>
    extends NamedTypeRepository<ID, T> {}
