package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.TestPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaTestPropertyTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification.TestPropertyTypeSpecification;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.JpaTestPropertyValueEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.specification.TestPropertyValueSpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPropertyTypeRepositoryImpl
    extends PropertyTypeRepositoryBase<
        Long,
        TestPropertyType,
        TestExtensibleTypeEntity,
        TestExtensibleEntity,
        TestPropertyTypeEntity,
        TestPropertyValueEntity> {
  private final JpaTestPropertyTypeEntityRepository jpaTestPropertyTypeEntityRepository;
  private final JpaTestExtensibleTypeEntityRepository jpaTestExtensibleTypeEntityRepository;
  private final JpaTestPropertyValueEntityRepository jpaTestPropertyValueEntityRepository;
  private final TestPropertyTypeEntityMapper testPropertyTypeEntityMapper;

  @Override
  protected JpaBaseRepository<TestPropertyTypeEntity, Long, Long> repository() {
    return jpaTestPropertyTypeEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestPropertyType, TestPropertyTypeEntity> mapper() {
    return testPropertyTypeEntityMapper;
  }

  @Override
  protected Specification<TestPropertyTypeEntity> name(String name) {
    return TestPropertyTypeSpecification.name(name);
  }

  @Override
  protected JpaBaseRepository<TestExtensibleTypeEntity, Long, Long>
      extensibleTypeEntityRepository() {
    return jpaTestExtensibleTypeEntityRepository;
  }

  @Override
  protected JpaBaseRepository<TestPropertyValueEntity, Long, Long> propertyValueEntityRepository() {
    return jpaTestPropertyValueEntityRepository;
  }

  @Override
  protected Specification<TestPropertyValueEntity> propertyType(Long propertyTypeId) {
    return TestPropertyValueSpecification.propertyType(propertyTypeId);
  }
}
