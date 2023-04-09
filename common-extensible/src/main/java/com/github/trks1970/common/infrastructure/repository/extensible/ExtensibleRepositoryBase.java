package com.github.trks1970.common.infrastructure.repository.extensible;

import com.github.trks1970.common.domain.model.extensible.Extensible;
import com.github.trks1970.common.domain.model.extensible.propertyvalue.PropertyValue;
import com.github.trks1970.common.domain.repository.extensible.ExtensibleRepository;
import java.io.Serializable;

public abstract class ExtensibleRepositoryBase<
        ID extends Serializable, P extends PropertyValue<ID>, T extends Extensible<ID, P>>
    implements ExtensibleRepository<ID, P, T> {}
