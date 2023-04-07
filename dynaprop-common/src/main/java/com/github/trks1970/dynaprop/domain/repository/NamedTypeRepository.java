package com.github.trks1970.dynaprop.domain.repository;

import com.github.trks1970.dynaprop.domain.model.Named;

import java.util.Optional;

public interface NamedTypeRepository<T extends Named> extends PersistentTypeRepository<T> {

  Optional<T> findByName(String name);
}