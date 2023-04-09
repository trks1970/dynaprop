package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.TestPropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.TestPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaTestPropertyTypeEntityRepository;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPropertyTypeRepositoryImpl extends PropertyTypeRepositoryBase<
      Long, TestPropertyType, TestExtensibleTypeEntity, TestExtensibleEntity, TestPropertyTypeEntity, TestPropertyValueEntity> {
  private final JpaTestPropertyTypeEntityRepository jpaTestPropertyTypeEntityRepository;
  private final TestPropertyTypeEntityMapper testPropertyTypeEntityMapper;
  @Override
  protected JpaBaseRepository<TestPropertyTypeEntity, Long, Long> repository() {
    return jpaTestPropertyTypeEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestPropertyType, TestPropertyTypeEntity> mapper() {
    return testPropertyTypeEntityMapper;
  }
}
