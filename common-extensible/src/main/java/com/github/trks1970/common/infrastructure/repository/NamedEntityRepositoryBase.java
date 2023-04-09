package com.github.trks1970.common.infrastructure.repository;

import com.github.trks1970.common.domain.model.Named;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.infrastructure.entity.NamedEntity;
import java.io.Serializable;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public abstract class NamedEntityRepositoryBase<
        ID extends Serializable, T extends Named<ID>, E extends NamedEntity<ID>>
    extends PersistentEntityRepositoryBase<ID, T, E> implements NamedTypeRepository<ID, T> {

  protected abstract Specification<E> nameSpecification(String name);

  @Override
  public Optional<T> findByName(String name) {
    log.debug("{} finding by name {}", getClass().getName(), name);
    return repository().findAll(nameSpecification(name)).stream().findFirst().map(this::toDomain);
  }
}
