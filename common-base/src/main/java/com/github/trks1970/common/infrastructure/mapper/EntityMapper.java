package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.IPersistent;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.io.Serializable;

public interface EntityMapper<
    ID extends Serializable, D extends IPersistent<ID>, E extends IPersistentEntity<ID>> {
  D toDomain(E entity);

  E toEntity(D type);

  E toEntity(D type, E entity);
}
