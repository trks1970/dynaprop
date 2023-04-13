package com.github.trks1970.common.infrastructure.repository.jpa;

import com.github.trks1970.common.infrastructure.entity.TestNamedEntity;
import java.util.UUID;

public interface JpaTestJpaNamedUuidEntityRepository
    extends JpaNamedEntityRepository<UUID, TestNamedEntity, Long> {}
