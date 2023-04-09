package com.github.trks1970.common.infrastructure.repository.extensible;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.domain.model.extensible.ExtensibleType;
import com.github.trks1970.common.domain.repository.extensible.ExtensibleTypeRepository;
import com.github.trks1970.common.infrastructure.entity.extensbile.ExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.entity.extensbile.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class ExtensibleTypeRepositoryBase<
        ID extends Serializable,
        T extends ExtensibleType<ID>,
        P extends PropertyTypeEntity<ID>,
        E extends ExtensibleTypeEntity<ID, P>>
    extends NamedEntityRepositoryBase<ID, T, E> implements ExtensibleTypeRepository<ID, T> {

  protected abstract JpaBaseRepository<P, ID, Long> propertyTypeRepository();

  @Override
  @SuppressWarnings("unchecked")
  public T addPropertyType(ID extensibleTypeId, ID propertyTypeId) {
    log.trace("addPropertyType {} ", propertyTypeId);
    E extensibleTypeEntity = findEntityById(extensibleTypeId);
    P propertyTypeEntity = findPropertyTypeEntityById(propertyTypeId);

    return mapper().toDomain((E) extensibleTypeEntity.addPropertyType(propertyTypeEntity));
  }

  @Override
  @SuppressWarnings("unchecked")
  public T removePropertyType(ID extensibleTypeId, ID propertyTypeId) {
    log.trace("addPropertyType {} ", propertyTypeId);
    E extensibleTypeEntity = findEntityById(extensibleTypeId);
    P propertyTypeEntity = findPropertyTypeEntityById(propertyTypeId);
    return mapper().toDomain((E) extensibleTypeEntity.removePropertyType(propertyTypeEntity));
  }

  private P findPropertyTypeEntityById(ID id) {
    return propertyTypeRepository()
        .findById(id)
        .orElseThrow(() -> new NotFoundException(ExtensibleTypeEntity.class, "by id " + id));
  }
}
