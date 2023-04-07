package com.github.trks1970.dynaprop.infrastructure.repository;

import com.github.trks1970.dynaprop.domain.model.Named;
import com.github.trks1970.dynaprop.domain.repository.NamedTypeRepository;
import com.github.trks1970.dynaprop.infrastructure.entity.NamedEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

@Slf4j
public abstract class NamedEntityRepositoryBase<T extends Named, E extends NamedEntity>
  extends PersistentEntityRepositoryBase<T, E>
  implements NamedTypeRepository<T> {

  protected abstract Specification<E> nameSpecification(String name);

  @Override
  public Optional<T> findByName(String name) {
    log.debug("{} finding by name {}", getClass().getName(), name);
    return repository().findAll(
        nameSpecification(name)
      ).stream()
      .findFirst()
      .map(this::toDomain);
  }
}
