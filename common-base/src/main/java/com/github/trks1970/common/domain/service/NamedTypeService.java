package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.model.Named;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional
public abstract class NamedTypeService<ID extends Serializable, T extends Named<ID>>
    extends PersistentTypeService<ID, T> {
  protected abstract NamedTypeRepository<ID, T> repository();

  public Optional<T> findByName(@Valid String name) {
    return repository().findByName(name);
  }
}
