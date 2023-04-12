package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.ReferenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultExtensibleTypeReferenceMapper
    extends ReferenceMapper<Long, DefaultExtensibleTypeEntity> {
  @PersistenceContext private final EntityManager entityManager;

  @Override
  protected EntityManager entityManager() {
    return entityManager;
  }

  @Override
  protected Class<DefaultExtensibleTypeEntity> entityClass() {
    return DefaultExtensibleTypeEntity.class;
  }
}
