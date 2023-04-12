package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.infrastructure.mapper.ReferenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultExtensibleReferenceMapper
    extends ReferenceMapper<Long, DefaultExtensibleEntity> {

  @PersistenceContext private final EntityManager entityManager;

  @Override
  protected EntityManager entityManager() {
    return entityManager;
  }

  @Override
  protected Class<DefaultExtensibleEntity> entityClass() {
    return DefaultExtensibleEntity.class;
  }
}
