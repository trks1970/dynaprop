package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaPersistentEntityRepository;
import java.io.Serializable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaExtensibleEntityRepository<
        ID extends Serializable,
        PTE extends IPropertyTypeEntity<ID>,
        ETE extends IExtensibleTypeEntity<ID, PTE>,
        EE extends IExtensibleEntity<ID, PTE, ETE>>
    extends JpaPersistentEntityRepository<ID, EE, Long> {}
