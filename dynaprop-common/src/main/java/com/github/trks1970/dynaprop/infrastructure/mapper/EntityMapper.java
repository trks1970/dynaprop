package com.github.trks1970.dynaprop.infrastructure.mapper;

import com.github.trks1970.dynaprop.domain.model.Persistent;
import com.github.trks1970.dynaprop.infrastructure.entity.PersistentEntity;

public interface EntityMapper<T extends Persistent, E extends PersistentEntity> {
  T toDomain(E entity);
  E toEntity(T type);
  E toEntity(T type, E entity);
}
