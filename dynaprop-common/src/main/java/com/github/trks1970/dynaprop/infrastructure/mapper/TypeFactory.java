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
public abstract class TypeFactory {
  @SuppressWarnings("squid:S1452") // has to be for parametrized polymorphism
  protected abstract Map<Class<?>, BiFunction<Class<? extends Persistent>, PersistentEntity, ? extends Persistent>> getFactories();

  @ObjectFactory
  @SuppressWarnings({"unchecked", "squid:S1452"})
  public <T extends Persistent> T createType(PersistentEntity source, @TargetType Class<T> typeClass) {
    log.debug("Getting PersistenceType for [{}] source {}", typeClass.getName(), source);
    return (T) getFactories().getOrDefault(typeClass, this::unknownType).apply(typeClass, source);
  }

  @SuppressWarnings("squid:S1452") // has to be for parametrized polymorphism
  private Persistent unknownType(Class<? extends Persistent> typeClass, PersistentEntity source) {
    log.error("Could not find TypeFactory for {}", typeClass.getName());
    throw new IllegalStateException("Could not find TypeFactory for " + typeClass.getName());
  }

}
