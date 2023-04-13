package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaNamedEntityRepository;
import java.io.Serializable;
import java.util.Set;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaPropertyValueEntityRepository<
        ID extends Serializable,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>,
        PTE extends IPropertyTypeEntity<ID, ETE>,
        PVE extends IPropertyValueEntity<ID, ETE, EE, PTE>>
    extends JpaNamedEntityRepository<ID, PVE, Long> {
}