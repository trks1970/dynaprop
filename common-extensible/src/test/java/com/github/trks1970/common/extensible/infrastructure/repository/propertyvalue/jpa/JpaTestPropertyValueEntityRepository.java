package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;

public interface JpaTestPropertyValueEntityRepository
    extends JpaBaseRepository<TestPropertyValueEntity, Long, Long> {}
