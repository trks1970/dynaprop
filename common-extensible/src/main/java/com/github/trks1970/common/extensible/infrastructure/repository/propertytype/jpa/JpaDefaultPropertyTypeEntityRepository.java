package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;

public interface JpaDefaultPropertyTypeEntityRepository
    extends JpaPropertyTypeRepository<
        Long, DefaultExtensibleTypeEntity, DefaultPropertyTypeEntity> {}
