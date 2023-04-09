package com.github.trks1970.common.domain.repository.extensible;

import com.github.trks1970.common.domain.model.extensible.Extensible;
import com.github.trks1970.common.domain.model.extensible.propertyvalue.PropertyValue;
import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import java.io.Serializable;

public interface ExtensibleRepository<
        ID extends Serializable, P extends PropertyValue<ID>, T extends Extensible<ID, P>>
    extends PersistentTypeRepository<ID, T> {}
