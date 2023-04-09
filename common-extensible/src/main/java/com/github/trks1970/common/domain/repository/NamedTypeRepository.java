package com.github.trks1970.common.domain.repository;

import com.github.trks1970.common.domain.model.Named;
import java.io.Serializable;
import java.util.Optional;

public interface NamedTypeRepository<ID extends Serializable, T extends Named<ID>>
    extends PersistentTypeRepository<ID, T> {

  Optional<T> findByName(String name);
}
