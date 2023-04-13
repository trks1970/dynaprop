package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.IPropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaNamedEntityRepository;
import java.io.Serializable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaPropertyValueEntityRepository<
        ID extends Serializable,
        PTE extends IPropertyTypeEntity<ID>,
        ETE extends IExtensibleTypeEntity<ID, PTE>,
        EE extends IExtensibleEntity<ID, PTE, ETE>,
        PVE extends IPropertyValueEntity<ID, PTE, ETE, EE>>
    extends JpaNamedEntityRepository<ID, PVE, Long> {}
