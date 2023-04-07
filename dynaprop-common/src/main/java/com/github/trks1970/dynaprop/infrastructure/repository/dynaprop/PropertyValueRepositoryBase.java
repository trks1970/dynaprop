package com.github.trks1970.dynaprop.infrastructure.repository.dynaprop;

import com.github.trks1970.dynaprop.domain.model.dynaprop.PropertyValue;
import com.github.trks1970.dynaprop.domain.repository.dynaprop.PropertyValueRepository;
import com.github.trks1970.dynaprop.infrastructure.entity.dynaprop.PropertyValueEntity;
import com.github.trks1970.dynaprop.infrastructure.repository.NamedEntityRepositoryBase;

public abstract class PropertyValueRepositoryBase<T extends PropertyValue, E extends PropertyValueEntity>
  extends NamedEntityRepositoryBase<T, E>
  implements PropertyValueRepository<T> {
}