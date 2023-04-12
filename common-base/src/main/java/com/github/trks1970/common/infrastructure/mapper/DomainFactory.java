package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.IPersistent;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class DomainFactory<
    ID extends Serializable, E extends IPersistentEntity<ID>, D extends IPersistent<ID>> {

  protected abstract Map<Class<D>, BiFunction<Class<D>, E, D>> getFactories();

  @ObjectFactory
  public D createType(E entity, @TargetType Class<D> domainClass) {
    log.trace("Creating PersistenceType for [{}] source {}", domainClass.getName(), entity);
    return getFactories().getOrDefault(domainClass, this::noType).apply(domainClass, entity);
  }

  private D noType(Class<D> domainClass, E entity) {
    log.error("Could not find TypeFactory for {}", domainClass.getName());
    throw new IllegalStateException("Could not find TypeFactory for " + domainClass.getName());
  }
}
