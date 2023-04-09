package com.github.trks1970.common.extensible.domain.repository.propertytype;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyType;
import java.io.Serializable;

public interface PropertyTypeRepository<ID extends Serializable, T extends PropertyType<ID>>
    extends NamedTypeRepository<ID, T> {}
