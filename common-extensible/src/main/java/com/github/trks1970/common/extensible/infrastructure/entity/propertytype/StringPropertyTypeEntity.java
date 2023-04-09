package com.github.trks1970.common.extensible.infrastructure.entity.propertytype;

import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import java.io.Serializable;

public interface StringPropertyTypeEntity<
        ID extends Serializable, E extends ExtensibleTypeEntity<ID>>
    extends PropertyTypeEntity<ID, E> {}
