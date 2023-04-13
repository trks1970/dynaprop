package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity;

public interface JpaDefaultPropertyValueEntityRepositoryJpa
    extends JpaPropertyValueRepositoryJpa<
        Long,
        DefaultExtensibleTypeEntity,
        DefaultExtensibleEntity,
        DefaultPropertyTypeEntity,
        DefaultPropertyValueEntity> {}
