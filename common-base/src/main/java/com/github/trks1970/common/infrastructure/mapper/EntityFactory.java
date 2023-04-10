package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.Persistent;
import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class EntityFactory<
    ID extends Serializable, D extends Persistent<ID>, E extends PersistentEntity<ID>> {

  protected abstract Map<Class<D>, BiFunction<Class<E>, D, E>> getFactories();

  @ObjectFactory
  public E createEntity(D domain, @TargetType Class<E> entityClass) {
    log.trace("Creating PersistenceEntity for [{}] source {}", entityClass.getName(), domain);
    return getFactories().getOrDefault(entityClass, this::unknownEntity).apply(entityClass, domain);
  }

  private E unknownEntity(Class<E> entityClass, D domain) {
    log.error("Could not find EntityFactory for {}", entityClass.getName());
    throw new IllegalStateException("Could not find EntityFactory for " + entityClass.getName());
  }
}
