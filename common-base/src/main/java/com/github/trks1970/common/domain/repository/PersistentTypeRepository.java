package com.github.trks1970.common.domain.repository;

import com.github.trks1970.common.domain.model.IPersistent;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface PersistentTypeRepository<ID extends Serializable, T extends IPersistent<ID>> {

  T save(T persistentType);

  T findById(ID id);

  List<T> findAllById(Set<ID> id);

  void deleteById(ID id);
}
