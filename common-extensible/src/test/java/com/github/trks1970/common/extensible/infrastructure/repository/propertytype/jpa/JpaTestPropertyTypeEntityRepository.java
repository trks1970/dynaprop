package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;

public interface JpaTestPropertyTypeEntityRepository
    extends JpaBaseRepository<TestPropertyTypeEntity, Long, Long> {}
