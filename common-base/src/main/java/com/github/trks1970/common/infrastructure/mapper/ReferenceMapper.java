package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import java.io.Serializable;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.lang.NonNull;

public abstract class ReferenceMapper<ID extends Serializable, E extends IPersistentEntity<ID>> {

  protected abstract EntityManager entityManager();

  protected abstract Class<E> entityClass();

  public E map(@NonNull final ID id) {
    return map(id, entityClass());
  }

  @ObjectFactory
  protected E map(@NonNull final ID id, @TargetType Class<E> type) {
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
}
