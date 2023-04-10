package com.github.trks1970.common.extensible.domain.repository;

import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.extensible.domain.model.Extensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.PropertyValue;
import java.io.Serializable;
import java.util.Set;

public interface ExtensibleRepository<
        ID extends Serializable, PV extends PropertyValue<ID>, T extends Extensible<ID>>
    extends PersistentTypeRepository<ID, T> {

  Set<PV> getPropertyValues(ID extensibleId);
}
