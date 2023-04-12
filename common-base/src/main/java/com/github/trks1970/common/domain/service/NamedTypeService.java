package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.model.INamed;
import java.io.Serializable;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public interface NamedTypeService<ID extends Serializable, T extends INamed<ID>>
    extends PersistentTypeService<ID, T> {

  @Transactional
  Set<T> findByName(String name);

  @Transactional
  boolean isNameUnique(String name);
}
