package com.github.trks1970.common.infrastructure.repository.extensible.propertytype;

import com.github.trks1970.common.domain.model.extensible.propertytype.PropertyType;
import com.github.trks1970.common.domain.repository.extensible.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.infrastructure.entity.extensbile.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;

public abstract class PropertyTypeRepositoryBase<
        ID extends Serializable, T extends PropertyType<ID>, E extends PropertyTypeEntity<ID>>
    extends NamedEntityRepositoryBase<ID, T, E> implements PropertyTypeRepository<ID, T> {}
