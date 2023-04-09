package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.Extensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.PropertyValue;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import java.io.Serializable;

public abstract class ExtensibleRepositoryBase<
        ID extends Serializable, P extends PropertyValue<ID>, T extends Extensible<ID, P>>
    implements ExtensibleRepository<ID, P, T> {}
