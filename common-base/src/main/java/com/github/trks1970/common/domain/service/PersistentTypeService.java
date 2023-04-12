package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.model.IPersistent;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public interface PersistentTypeService<ID extends Serializable, T extends IPersistent<ID>> {

  @Transactional
  T save(@Valid T persistentType);

  @Transactional
  T findById(ID id);

  @Transactional
  List<T> findAllById(Set<ID> ids);

  @Transactional
  void deleteById(ID id);
}
