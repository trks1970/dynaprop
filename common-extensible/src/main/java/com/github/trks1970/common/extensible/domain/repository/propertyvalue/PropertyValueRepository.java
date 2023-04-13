package com.github.trks1970.common.extensible.domain.repository.propertyvalue;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import java.io.Serializable;
import java.util.Set;

public interface PropertyValueRepository<ID extends Serializable, T extends IPropertyValue<ID>>
    extends NamedTypeRepository<ID, T> {
}
