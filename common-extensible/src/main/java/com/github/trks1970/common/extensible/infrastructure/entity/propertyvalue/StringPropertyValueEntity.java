package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import java.io.Serializable;

public interface StringPropertyValueEntity<
        ID extends Serializable,
        ET extends ExtensibleTypeEntity<ID>,
        E extends ExtensibleEntity<ID, ET>,
        PT extends PropertyTypeEntity<ID, ET>>
    extends PropertyValueEntity<ID, ET, E, PT> {}
