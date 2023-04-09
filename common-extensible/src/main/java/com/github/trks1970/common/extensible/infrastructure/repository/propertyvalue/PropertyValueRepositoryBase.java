package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.PropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.PropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;

public abstract class PropertyValueRepositoryBase<
        ID extends Serializable, T extends PropertyValue<ID>, E extends PropertyValueEntity<ID>>
    extends NamedEntityRepositoryBase<ID, T, E> implements PropertyValueRepository<ID, T> {}
