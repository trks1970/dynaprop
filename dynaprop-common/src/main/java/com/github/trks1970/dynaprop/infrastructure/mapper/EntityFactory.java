package com.github.trks1970.dynaprop.infrastructure.mapper;

import com.github.trks1970.dynaprop.domain.model.Persistent;
import com.github.trks1970.dynaprop.infrastructure.entity.PersistentEntity;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.BiFunction;

@Component
@Slf4j
public abstract class EntityFactory {
  @SuppressWarnings("squid:S1452") // has to be for parametrized polymorphism
  protected abstract Map<Class<?>, BiFunction<Class<? extends PersistentEntity>, Persistent, ? extends PersistentEntity>> getFactories();

  @ObjectFactory
  @SuppressWarnings({"unchecked", "squid:S1452"})
  public <T extends PersistentEntity> T createEntity(Persistent source, @TargetType Class<T> entityClass) {
    log.debug("Getting PersistenceEntity for [{}] source {}", entityClass.getName(), source);
    return (T) getFactories().getOrDefault(entityClass, this::unknownEntity).apply(entityClass, source);
  }

  @SuppressWarnings("squid:S1452") // has to be for parametrized polymorphism
  private PersistentEntity unknownEntity(Class<? extends PersistentEntity> entityClass, Persistent source) {
    log.error("Could not find EntityFactory for {}", entityClass.getName());
    throw new IllegalStateException("Could not find EntityFactory for " + entityClass.getName());
  }

}
