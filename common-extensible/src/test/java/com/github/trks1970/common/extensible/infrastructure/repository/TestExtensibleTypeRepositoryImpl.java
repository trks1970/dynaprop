package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity_;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.TestExtensibleTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.TestPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.specification.TestExtensibleTypeSpecification;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaTestPropertyTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification.TestPropertyTypeSpecification;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.JpaTestPropertyValueEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.specification.TestPropertyValueSpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestExtensibleTypeRepositoryImpl
    extends ExtensibleTypeRepositoryBase<
        Long,
        TestExtensibleType,
        TestPropertyType,
        TestExtensibleTypeEntity,
        TestExtensibleEntity,
        TestPropertyTypeEntity,
        TestPropertyValueEntity> {
  private final JpaTestExtensibleTypeEntityRepository jpaTestExtensibleTypeEntityRepository;
  private final JpaTestPropertyTypeEntityRepository jpaTestPropertyTypeEntityRepository;
  private final JpaTestPropertyValueEntityRepository jpaTestPropertyValueEntityRepository;
  private final TestExtensibleTypeEntityMapper testExtensibleTypeEntityMapper;
  private final TestPropertyTypeEntityMapper testPropertyTypeEntityMapper;

  @Override
  protected JpaBaseRepository<TestExtensibleTypeEntity, Long, Long> repository() {
    return jpaTestExtensibleTypeEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestExtensibleType, TestExtensibleTypeEntity> mapper() {
    return testExtensibleTypeEntityMapper;
  }

  @Override
  protected JpaBaseRepository<TestPropertyTypeEntity, Long, Long> propertyTypeEntityRepository() {
    return jpaTestPropertyTypeEntityRepository;
  }

  @Override
  protected JpaBaseRepository<TestPropertyValueEntity, Long, Long> propertyValueEntityRepository() {
    return jpaTestPropertyValueEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestPropertyType, TestPropertyTypeEntity> propertyTypeMapper() {
    return testPropertyTypeEntityMapper;
  }

  @Override
  protected String getIdPropertyName() {
    return TestExtensibleTypeEntity_.NAME;
  }

  @Override
  protected Specification<TestExtensibleTypeEntity> name(String name) {
    return TestExtensibleTypeSpecification.name(name);
  }

  @Override
  protected Specification<TestPropertyTypeEntity> extensibleType(Long extensibleTypeId) {
    return TestPropertyTypeSpecification.extensibleTypeId(extensibleTypeId);
  }

  @Override
  protected Specification<TestPropertyValueEntity> propertyTypes(Set<Long> propertyTypeIds) {
    return TestPropertyValueSpecification.propertyTypes(propertyTypeIds);
  }
}
