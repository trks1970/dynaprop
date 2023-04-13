package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;

public interface JpaDefaultExtensibleEntityRepository
    extends JpaExtensibleEntityRepository<
        Long, DefaultPropertyTypeEntity, DefaultExtensibleTypeEntity, DefaultExtensibleEntity> {}
