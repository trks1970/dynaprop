package com.github.trks1970.dynaprop.infrastructure.repository.dynaprop;

import com.github.trks1970.dynaprop.domain.model.dynaprop.PropertyType;
import com.github.trks1970.dynaprop.domain.repository.dynaprop.PropertyTypeRepository;
import com.github.trks1970.dynaprop.infrastructure.entity.dynaprop.PropertyTypeEntity;
import com.github.trks1970.dynaprop.infrastructure.repository.NamedEntityRepositoryBase;

public abstract class PropertyTypeRepositoryBase<T extends PropertyType, E extends PropertyTypeEntity>
  extends NamedEntityRepositoryBase<T, E>
  implements PropertyTypeRepository<T> {
}
