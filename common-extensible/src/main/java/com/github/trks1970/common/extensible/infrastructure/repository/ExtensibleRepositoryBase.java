package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.repository.PersistentEntityRepositoryBase;
import java.io.Serializable;

public abstract class ExtensibleRepositoryBase<
        ID extends Serializable,
        E extends IExtensible<ID>,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>>
    extends PersistentEntityRepositoryBase<ID, E, EE> implements ExtensibleRepository<ID, E> {}
