package com.github.trks1970.dynaprop.infrastructure.repository.dynaprop;

import com.github.trks1970.dynaprop.domain.exception.NotFoundException;
import com.github.trks1970.dynaprop.domain.model.dynaprop.ExtensibleType;
import com.github.trks1970.dynaprop.domain.repository.dynaprop.ExtensibleTypeRepository;
import com.github.trks1970.dynaprop.infrastructure.entity.dynaprop.ExtensibleTypeEntity;
import com.github.trks1970.dynaprop.infrastructure.entity.dynaprop.PropertyTypeEntity;
import com.github.trks1970.dynaprop.infrastructure.repository.NamedEntityRepositoryBase;
import com.github.trks1970.dynaprop.infrastructure.repository.jpa.JPABaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class ExtensibleTypeRepositoryBase<T extends ExtensibleType, E extends ExtensibleTypeEntity<? extends PropertyTypeEntity>>
  extends NamedEntityRepositoryBase<T, E>
  implements ExtensibleTypeRepository<T> {
  @SuppressWarnings("squid:S1452") // has to be for parametrized polymorphism
  protected abstract JPABaseRepository<? extends PropertyTypeEntity, Long, Long> propertyTypeRepository();

  @Override
  @SuppressWarnings("unchecked")
  public T addPropertyType(Long extensibleTypeId, Long propertyTypeId) {
    log.trace("addPropertyType {} ", propertyTypeId);
    E extensibleTypeEntity = findEntityById(extensibleTypeId);
    PropertyTypeEntity propertyTypeEntity = findPropertyTypeEntityById(propertyTypeId);

    return mapper().toDomain(
      (E) extensibleTypeEntity.addPropertyType(propertyTypeEntity)
    );
  }

  @Override
  @SuppressWarnings("unchecked")
  public T removePropertyType(Long extensibleTypeId, Long propertyTypeId) {
    log.trace("addPropertyType {} ", propertyTypeId);
    E extensibleTypeEntity = findEntityById(extensibleTypeId);
    PropertyTypeEntity propertyTypeEntity = findPropertyTypeEntityById(propertyTypeId);
    return mapper().toDomain(
      (E) extensibleTypeEntity.removePropertyType(propertyTypeEntity)
    );
  }

  private PropertyTypeEntity findPropertyTypeEntityById(Long id) {
    return propertyTypeRepository().findById(id)
      .orElseThrow(() -> new NotFoundException(ExtensibleTypeEntity.class, "by id " + id));

  }
}
