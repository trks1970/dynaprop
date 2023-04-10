package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;

public interface JpaTestExtensibleTypeEntityRepository
    extends JpaBaseRepository<TestExtensibleTypeEntity, Long, Long> {}
