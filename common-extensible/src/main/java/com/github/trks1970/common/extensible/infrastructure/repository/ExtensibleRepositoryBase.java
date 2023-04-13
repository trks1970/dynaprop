package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.PersistentEntityRepositoryBase;
import java.io.Serializable;

public abstract class ExtensibleRepositoryBase<
        ID extends Serializable,
        E extends IExtensible<ID>,
        PTE extends IPropertyTypeEntity<ID>,
        ETE extends IExtensibleTypeEntity<ID, PTE>,
        EE extends IExtensibleEntity<ID, PTE, ETE>>
    extends PersistentEntityRepositoryBase<ID, E, EE> implements ExtensibleRepository<ID, E> {}
