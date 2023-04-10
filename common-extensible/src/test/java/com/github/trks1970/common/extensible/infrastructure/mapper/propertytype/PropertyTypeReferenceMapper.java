package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.ReferenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PropertyTypeReferenceMapper extends ReferenceMapper<Long, TestPropertyTypeEntity> {

  @PersistenceContext private final EntityManager entityManager;

  @Override
  protected EntityManager entityManager() {
    return entityManager;
  }

  @Override
  protected Class<TestPropertyTypeEntity> entityClass() {
    return TestPropertyTypeEntity.class;
  }
}
