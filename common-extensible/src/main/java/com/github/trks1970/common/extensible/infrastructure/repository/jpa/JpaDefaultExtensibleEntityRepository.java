package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;

public interface JpaDefaultExtensibleEntityRepository
    extends JpaExtensibleEntityRepository<
        Long, DefaultExtensibleTypeEntity, DefaultExtensibleEntity> {}
