package com.github.trks1970.common.extensible.domain.repository;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.ExtensibleType;
import java.io.Serializable;

public interface ExtensibleTypeRepository<ID extends Serializable, T extends ExtensibleType<ID>>
    extends NamedTypeRepository<ID, T> {}
