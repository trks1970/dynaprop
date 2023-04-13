package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDefaultPropertyTypeEntityRepository
    extends JpaPropertyTypeEntityRepository<Long, DefaultPropertyTypeEntity> {}
