package com.github.trks1970.common.extensible.domain.repository;

import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import java.io.Serializable;
import java.util.Set;

public interface ExtensibleRepository<
        ID extends Serializable, PV extends IPropertyValue<ID>, T extends IExtensible<ID>>
    extends PersistentTypeRepository<ID, T> {

  Set<PV> getPropertyValues(ID extensibleId);
}
