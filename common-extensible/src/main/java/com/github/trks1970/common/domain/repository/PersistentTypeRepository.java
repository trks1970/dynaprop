package com.github.trks1970.common.domain.repository;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.domain.model.Persistent;
import java.io.Serializable;
import java.util.Set;

public interface PersistentTypeRepository<ID extends Serializable, T extends Persistent<ID>> {
  T save(T persistentType);

  T findById(ID id) throws NotFoundException;

  Set<T> findAllById(Set<ID> id) throws NotFoundException;

  void deleteById(ID id) throws NotFoundException;
}
