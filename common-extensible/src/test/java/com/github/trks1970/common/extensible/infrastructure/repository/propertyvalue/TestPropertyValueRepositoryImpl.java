package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.TestPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.TestPropertyValueRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue.TestPropertyValueEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.JpaTestPropertyValueEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.specification.TestPropertyValueSpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPropertyValueRepositoryImpl
    extends PropertyValueRepositoryBase<
        Long,
        TestExtensibleTypeEntity,
        TestExtensibleEntity,
        TestPropertyValue,
        TestPropertyTypeEntity,
        TestPropertyValueEntity>
    implements TestPropertyValueRepository {
  private final JpaTestPropertyValueEntityRepository jpaTestPropertyValueEntityRepository;
  private final JpaTestExtensibleEntityRepository jpaTestExtensibleEntityRepository;
  private final TestPropertyValueEntityMapper testPropertyValueEntityMapper;

  @Override
  protected JpaBaseRepository<TestPropertyValueEntity, Long, Long> repository() {
    return jpaTestPropertyValueEntityRepository;
  }

  @Override
  protected JpaBaseRepository<TestExtensibleEntity, Long, Long> extensibleEntityRepository() {
    return jpaTestExtensibleEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestPropertyValue, TestPropertyValueEntity> mapper() {
    return testPropertyValueEntityMapper;
  }

  @Override
  protected Specification<TestPropertyValueEntity> name(String name) {
    return TestPropertyValueSpecification.name(name);
  }
}
