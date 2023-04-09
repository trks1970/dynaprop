package com.github.trks1970.common.domain.repository.extensible.propertytype;

import com.github.trks1970.common.domain.model.extensible.propertytype.PropertyType;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import java.io.Serializable;

public interface PropertyTypeRepository<ID extends Serializable, T extends PropertyType<ID>>
    extends NamedTypeRepository<ID, T> {}
