package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.NamedEntityRepository;

public interface JpaDefaultExtensibleTypeEntityRepository
    extends NamedEntityRepository<DefaultExtensibleTypeEntity, Long, Long> {}
