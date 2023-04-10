package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.domain.repository.TestExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.TestExtensibleTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.specification.TestExtensibleTypeSpecification;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaTestPropertyTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification.TestPropertyTypeSpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestExtensibleTypeRepositoryImpl
    extends ExtensibleTypeRepositoryBase<Long, TestExtensibleType, TestExtensibleTypeEntity>
    implements TestExtensibleTypeRepository {

  private final JpaTestExtensibleTypeEntityRepository jpaTestExtensibleTypeEntityRepository;
  private final JpaTestPropertyTypeEntityRepository jpaTestPropertyTypeEntityRepository;
  private final TestExtensibleTypeEntityMapper testExtensibleTypeEntityMapper;

  @Override
  public void deleteById(Long extensibleTypeId) {
    Set<IdProjection> propertyTypeIds =
        new HashSet<>(
            jpaTestPropertyTypeEntityRepository.findBy(
                TestPropertyTypeSpecification.extensibleTypeId(extensibleTypeId),
                fetchableFluentQuery ->
                    fetchableFluentQuery.as(IdProjection.class).project("id").all()));
    jpaTestPropertyTypeEntityRepository.deleteAllById(
        propertyTypeIds.stream().map(IdProjection::getId).collect(Collectors.toSet()));
    repository().deleteById(extensibleTypeId);
  }

  @Override
  protected JpaBaseRepository<TestExtensibleTypeEntity, Long, Long> repository() {
    return jpaTestExtensibleTypeEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestExtensibleType, TestExtensibleTypeEntity> mapper() {
    return testExtensibleTypeEntityMapper;
  }

  @Override
  protected Specification<TestExtensibleTypeEntity> name(String name) {
    return TestExtensibleTypeSpecification.name(name);
  }
}
