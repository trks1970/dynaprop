package com.github.trks1970.common.extensible.domain.repository;

import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.extensible.domain.model.IExtensible;
import java.io.Serializable;

public interface ExtensibleRepository<ID extends Serializable, T extends IExtensible<ID>>
    extends PersistentTypeRepository<ID, T> {}
