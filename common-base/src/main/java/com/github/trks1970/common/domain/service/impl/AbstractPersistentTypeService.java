package com.github.trks1970.common.domain.service.impl;

import com.github.trks1970.common.domain.model.IPersistent;
import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.domain.service.PersistentTypeService;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractPersistentTypeService<
        ID extends Serializable, T extends IPersistent<ID>>
    implements PersistentTypeService<ID, T> {
  protected abstract PersistentTypeRepository<ID, T> repository();

  @Transactional
  public T save(@Valid T persistentType) {
    return repository().save(persistentType);
  }

  @Transactional
  public T findById(ID id) {
    return repository().findById(id);
  }

  @Transactional
  public List<T> findAllById(Set<ID> ids) {
    return repository().findAllById(ids);
  }

  @Transactional
  public void deleteById(ID id) {
    repository().deleteById(id);
  }
}
