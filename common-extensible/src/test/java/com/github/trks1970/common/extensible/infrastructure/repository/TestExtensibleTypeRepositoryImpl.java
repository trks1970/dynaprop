package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.repository.TestExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.TestExtensibleTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleTypeEntityRepository;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestExtensibleTypeRepositoryImpl
    extends ExtensibleTypeRepositoryBase<Long, TestExtensibleType, TestPropertyType, TestExtensibleTypeEntity, TestExtensibleEntity, TestPropertyTypeEntity,TestPropertyValueEntity>  {
  private final JpaTestExtensibleTypeEntityRepository jpaTestExtensibleTypeEntityRepository;
  private final TestExtensibleTypeEntityMapper testExtensibleTypeEntityMapper;

  @Override
  protected JpaBaseRepository<TestExtensibleTypeEntity, Long, Long> repository() {
    return jpaTestExtensibleTypeEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestExtensibleType, TestExtensibleTypeEntity> mapper() {
    return testExtensibleTypeEntityMapper;
  }
}
