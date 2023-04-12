package com.github.trks1970.common.domain.service.impl;

import com.github.trks1970.common.domain.model.INamed;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.domain.service.NamedTypeService;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractNamedTypeService<ID extends Serializable, T extends INamed<ID>>
    extends AbstractPersistentTypeService<ID, T> implements NamedTypeService<ID, T> {
  protected abstract NamedTypeRepository<ID, T> repository();

  @Transactional
  public Set<T> findByName(@Valid String name) {
    return repository().findByName(name);
  }

  @Transactional
  public boolean isNameUnique(String name) {
    return repository().isNameUnique(name);
  }
}
