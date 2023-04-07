package com.github.trks1970.dynaprop.domain.repository;

import com.github.trks1970.dynaprop.domain.exception.NotFoundException;
import com.github.trks1970.dynaprop.domain.model.Persistent;

import java.util.Set;

public interface PersistentTypeRepository<T extends Persistent> {
  T save(T persistentType);
  T findById(Long id) throws NotFoundException;

  Set<T> findAllById(Set<Long> id) throws NotFoundException;
  void deleteById(Long id) throws NotFoundException;

}