package com.github.trks1970.common.extensible.domain.repository;

import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.extensible.domain.model.Extensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.PropertyValue;
import java.io.Serializable;

public interface ExtensibleRepository<
        ID extends Serializable, P extends PropertyValue<ID>, T extends Extensible<ID, P>>
    extends PersistentTypeRepository<ID, T> {}
