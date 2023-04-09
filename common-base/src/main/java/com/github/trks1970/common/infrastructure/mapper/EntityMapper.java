package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.Persistent;
import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import java.io.Serializable;

public interface EntityMapper<
    ID extends Serializable, T extends Persistent<ID>, E extends PersistentEntity<ID>> {
  T toDomain(E entity);

  E toEntity(T type);

  E toEntity(T type, E entity);
}
