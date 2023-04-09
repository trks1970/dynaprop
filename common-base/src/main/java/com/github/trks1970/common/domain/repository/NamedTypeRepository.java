package com.github.trks1970.common.domain.repository;

import com.github.trks1970.common.domain.model.Named;
import java.io.Serializable;
import java.util.Set;

public interface NamedTypeRepository<ID extends Serializable, T extends Named<ID>>
    extends PersistentTypeRepository<ID, T> {

  Set<T> findByName(String name);
}
