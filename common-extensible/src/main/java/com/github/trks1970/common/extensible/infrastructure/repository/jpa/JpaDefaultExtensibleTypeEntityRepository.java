package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaNamedEntityRepository;

public interface JpaDefaultExtensibleTypeEntityRepository
    extends JpaNamedEntityRepository<Long, DefaultExtensibleTypeEntity, Long> {}
