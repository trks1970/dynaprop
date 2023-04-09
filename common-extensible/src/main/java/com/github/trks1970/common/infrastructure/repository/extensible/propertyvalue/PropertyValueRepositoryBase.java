package com.github.trks1970.common.infrastructure.repository.extensible.propertyvalue;

import com.github.trks1970.common.domain.model.extensible.propertyvalue.PropertyValue;
import com.github.trks1970.common.domain.repository.extensible.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.infrastructure.entity.extensbile.propertyvalue.PropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;

public abstract class PropertyValueRepositoryBase<
        ID extends Serializable, T extends PropertyValue<ID>, E extends PropertyValueEntity<ID>>
    extends NamedEntityRepositoryBase<ID, T, E> implements PropertyValueRepository<ID, T> {}
