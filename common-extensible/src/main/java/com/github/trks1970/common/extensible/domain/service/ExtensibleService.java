package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.domain.service.PersistentTypeService;
import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import java.io.Serializable;

public interface ExtensibleService<
        ID extends Serializable, E extends IExtensible<ID>, P extends IPropertyValue<ID>>
    extends PersistentTypeService<ID, E> {}
