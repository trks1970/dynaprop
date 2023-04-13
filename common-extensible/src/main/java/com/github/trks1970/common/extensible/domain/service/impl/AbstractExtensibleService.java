package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.service.impl.AbstractPersistentTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.extensible.domain.service.ExtensibleService;
import java.io.Serializable;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractExtensibleService<
        ID extends Serializable, E extends IExtensible<ID>, P extends IPropertyValue<ID>>
    extends AbstractPersistentTypeService<ID, E> implements ExtensibleService<ID, E, P> {

  protected abstract PropertyValueRepository<ID, P> propertyValueRepository();

  @Override
  @Transactional
  public Set<P> getPropertyValues(ID extensibleTypeId) {
    return propertyValueRepository().getPropertyValues(extensibleTypeId);
  }

  @Override
  @Transactional
  public P addPropertyValue(P propertyValue) {
    return propertyValueRepository().save(propertyValue);
  }

  @Override
  @Transactional
  public void removePropertyValue(P propertyValue) {
    propertyValueRepository().deleteById(propertyValue.getId());
  }
}
