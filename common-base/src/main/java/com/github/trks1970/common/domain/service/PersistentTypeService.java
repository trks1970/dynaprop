package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.domain.model.Persistent;
import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional
public abstract class PersistentTypeService<ID extends Serializable, T extends Persistent<ID>> {
  protected abstract PersistentTypeRepository<ID, T> repository();

  public T save(@Valid T persistentType) {
    return repository().save(persistentType);
  }

  public T findById(ID id) throws NotFoundException {
    return repository().findById(id);
  }

  public List<T> findAllById(Set<ID> ids) throws NotFoundException {
    return repository().findAllById(ids);
  }

  public void deleteById(ID id) throws NotFoundException {
    repository().deleteById(id);
  }
}
