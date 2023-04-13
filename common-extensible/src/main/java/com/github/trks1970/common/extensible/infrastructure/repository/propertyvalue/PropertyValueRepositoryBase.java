package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;

public abstract class PropertyValueRepositoryBase<
        ID extends Serializable,
        PTE extends IPropertyTypeEntity<ID>,
        ETE extends IExtensibleTypeEntity<ID, PTE>,
        EE extends IExtensibleEntity<ID, PTE, ETE>,
        VT extends IPropertyValue<ID>,
        PVE extends IPropertyValueEntity<ID, PTE, ETE, EE>>
    extends NamedEntityRepositoryBase<ID, VT, PVE> implements PropertyValueRepository<ID, VT> {}
