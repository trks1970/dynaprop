package com.github.trks1970.dynaprop.domain.repository.dynaprop;

import com.github.trks1970.dynaprop.domain.model.dynaprop.Extensible;
import com.github.trks1970.dynaprop.domain.repository.PersistentTypeRepository;

public interface ExtensibleRepository<T extends Extensible> extends PersistentTypeRepository<T> {
}
