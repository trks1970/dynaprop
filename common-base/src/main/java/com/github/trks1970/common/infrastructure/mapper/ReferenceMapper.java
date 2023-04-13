package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import java.io.Serializable;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public abstract class ReferenceMapper<ID extends Serializable, E extends IPersistentEntity<ID>> {

  protected abstract EntityManager entityManager();

  protected abstract Class<E> entityClass();

  public @Nullable E mapOptional(@Nullable final ID id) {
    return mapOptional(id, entityClass());
  }

  public @NonNull E mapRequired(@NonNull final ID id) {
    return mapRequired(id, entityClass());
  }

  @ObjectFactory
  protected @NonNull E mapRequired(@NonNull final ID id, @TargetType Class<E> type) {
    E entity;
    try {
      entity = entityManager().getReference(type, id);
      // fail fast
      entity.getId();
      return entity;
    } catch (EntityNotFoundException e) {
      throw new NotFoundException(type, "id=[" + id + "]");
    }
  }

  @ObjectFactory
  protected @Nullable E mapOptional(@Nullable final ID id, @TargetType Class<E> type) {
    if (id == null) {
      return null;
    }
    return mapRequired(id, type);
  }
}
