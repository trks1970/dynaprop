package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.TestPropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.TestPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaTestPropertyTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification.TestPropertyTypeSpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPropertyTypeRepositoryImpl
    extends PropertyTypeRepositoryBase<
        Long, TestPropertyType, TestExtensibleTypeEntity, TestPropertyTypeEntity>
    implements TestPropertyTypeRepository {

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

  @Override
  protected Specification<TestPropertyTypeEntity> name(String name) {
    return TestPropertyTypeSpecification.name(name);
  }

  @Override
  protected Specification<TestPropertyTypeEntity> extensibleType(Long extensibleTypeId) {
    return TestPropertyTypeSpecification.extensibleTypeId(extensibleTypeId);
  }
}
