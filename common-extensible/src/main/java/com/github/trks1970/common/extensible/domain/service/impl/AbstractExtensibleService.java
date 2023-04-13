package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.service.impl.AbstractPersistentTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.service.ExtensibleService;
import java.io.Serializable;

public abstract class AbstractExtensibleService<
        ID extends Serializable, E extends IExtensible<ID>, P extends IPropertyValue<ID>>
    extends AbstractPersistentTypeService<ID, E> implements ExtensibleService<ID, E, P> {}
