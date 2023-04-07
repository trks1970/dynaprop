package com.github.trks1970.dynaprop.infrastructure.repository;

import com.github.trks1970.dynaprop.domain.exception.NotFoundException;
import com.github.trks1970.dynaprop.domain.model.Persistent;
import com.github.trks1970.dynaprop.domain.repository.PersistentTypeRepository;
import com.github.trks1970.dynaprop.infrastructure.entity.PersistentEntity;
import com.github.trks1970.dynaprop.infrastructure.mapper.EntityMapper;
import com.github.trks1970.dynaprop.infrastructure.repository.jpa.JPABaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public abstract class PersistentEntityRepositoryBase<T extends Persistent, E extends PersistentEntity> implements
    PersistentTypeRepository<T> {

  protected abstract JPABaseRepository<E, Long, Long> repository();

  protected abstract EntityMapper<T, E> mapper();

  protected abstract Class<T> getTypeClass();

  @Override
  public T save(T item) {
    log.debug("Saving {}, {}", getTypeClass().getName(), item);
    E itemEntity;
    if (item.getId() == null) {
      itemEntity = repository().save(
        mapper().toEntity(item)
      );
    } else {
      itemEntity = repository().save(
        mapper().toEntity(
          item,
          findEntityById(item.getId())
        )
      );
    }
    log.debug("Saved as entity {}", itemEntity);
    return toDomain(itemEntity);
  }

  @Override
  public T findById(Long id) throws NotFoundException {
    log.debug("Finding type {} by id {}", getTypeClass().getName(), id);
    return toDomain(
      findEntityById(id)
    );
  }

  @Override
  public Set<T> findAllById(Set<Long> ids) throws NotFoundException {
    log.debug("Finding {} by ids {}", getTypeClass().getName(), ids);
    return repository().findAllById(ids)
      .stream()
      .map(this::toDomain)
      .collect(Collectors.toSet());
  }

  @Override
  public void deleteById(Long id) {
    log.debug("Deleting {} by id {}", getTypeClass().getName(), id);
    repository().deleteById(id);
  }

  @NonNull
  public E findEntityById(@NonNull Long id) {
    log.debug("Finding entity for type {} by id {}", getTypeClass().getName(), id);
    return repository().findById(id)
      .orElseThrow(() -> new NotFoundException(getTypeClass(), "id " + id));
  }

  protected T toDomain(E entity) {
    return mapper().toDomain(entity);
  }
}
