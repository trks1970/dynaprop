package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.ReferenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPropertyTypeReferenceMapper
    extends ReferenceMapper<Long, DefaultPropertyTypeEntity> {

  @PersistenceContext private final EntityManager entityManager;

  @Override
  protected EntityManager entityManager() {
    return entityManager;
  }

  @Override
  protected Class<DefaultPropertyTypeEntity> entityClass() {
    return DefaultPropertyTypeEntity.class;
  }
}
