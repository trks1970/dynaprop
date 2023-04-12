package com.github.trks1970.common.infrastructure.repository;

import com.github.trks1970.common.domain.exception.IntegrityViolationException;
import com.github.trks1970.common.domain.model.INamed;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.NamedEntityRepository;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public abstract class NamedEntityRepositoryBase<
        ID extends Serializable, T extends INamed<ID>, E extends INamedEntity<ID>>
    extends PersistentEntityRepositoryBase<ID, T, E> implements NamedTypeRepository<ID, T> {

  protected abstract Specification<E> name(String name);

  protected abstract NamedEntityRepository<E, ID, Long> repository();

  @Override
  public Set<T> findByName(String name) {
    log.trace("{} finding by name {}", getClass().getName(), name);
    return repository().findAll(name(name)).stream()
        .map(this::toDomain)
        .collect(Collectors.toSet());
  }

  @Override
  public T save(T item) {

    if (repository().findByName(item.getName()).isEmpty()) {
      return super.save(item);
    }
    throw new IntegrityViolationException(
        item.getClass() + " name [" + item.getName() + "] is not unique");
  }
}
