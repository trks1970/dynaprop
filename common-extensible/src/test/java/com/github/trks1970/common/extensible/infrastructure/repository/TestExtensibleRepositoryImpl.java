package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.TestExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.TestPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.TestExtensibleRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.TestExtensibleEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.JpaTestPropertyValueEntityRepository;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestExtensibleRepositoryImpl
    extends ExtensibleRepositoryBase<
        Long,
        TestPropertyValue,
        TestExtensible,
        TestExtensibleTypeEntity,
        TestPropertyTypeEntity,
        TestExtensibleEntity,
        TestPropertyValueEntity>
    implements TestExtensibleRepository {

  private final JpaTestExtensibleEntityRepository jpaTestExtensibleEntityRepository;
  private final JpaTestPropertyValueEntityRepository jpaTestPropertyValueEntityRepository;
  private final TestExtensibleEntityMapper testExtensibleEntityMapper;

  @Override
  protected JpaBaseRepository<TestExtensibleEntity, Long, Long> repository() {
    return jpaTestExtensibleEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestExtensible, TestExtensibleEntity> mapper() {
    return testExtensibleEntityMapper;
  }

  @Override
  protected JpaBaseRepository<TestPropertyValueEntity, Long, Long> propertyValueEntityRepository() {
    return jpaTestPropertyValueEntityRepository;
  }

  @Override
  protected Specification<TestPropertyValueEntity> forExtensibleId(Long extensibleId) {
    return null;
  }

  @Override
  protected EntityMapper<Long, TestPropertyValue, TestPropertyValueEntity>
      propertyValueEntityMapper() {
    return null;
  }

  @Override
  protected Collection<String> getQueryAttributes() {
    return null;
  }
}
