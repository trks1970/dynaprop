package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;

public interface JpaTestExtensibleEntityRepository
    extends JpaBaseRepository<TestExtensibleEntity, Long, Long> {}
