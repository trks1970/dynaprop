package com.github.trks1970.common.infrastructure.repository.jpa;

import com.github.trks1970.common.infrastructure.entity.TestNamedUuidEntity;
import java.util.UUID;

public interface JpaTestNamedUuidEntityRepository
    extends JpaBaseRepository<TestNamedUuidEntity, UUID, Long> {}
