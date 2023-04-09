package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.Extensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.PropertyValue;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import java.io.Serializable;

public abstract class ExtensibleRepositoryBase<
        ID extends Serializable, PV extends PropertyValue<ID>, E extends Extensible<ID>>
    implements ExtensibleRepository<ID, PV, E> {}
