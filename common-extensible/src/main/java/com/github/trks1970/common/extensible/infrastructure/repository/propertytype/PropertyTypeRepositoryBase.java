package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;

public abstract class PropertyTypeRepositoryBase<
        ID extends Serializable, T extends PropertyType<ID>, E extends PropertyTypeEntity<ID>>
    extends NamedEntityRepositoryBase<ID, T, E> implements PropertyTypeRepository<ID, T> {}
