package com.github.trks1970.common.infrastructure.repository;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.domain.model.IPersistent;
import com.github.trks1970.common.domain.model.TestINamedUuid;
import com.github.trks1970.common.domain.repository.TestNamedUuidRepository;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import com.github.trks1970.common.infrastructure.entity.TestNamedEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.mapper.TestNamedUuidEntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaTestNamedUuidEntityRepository;
import com.github.trks1970.common.infrastructure.repository.jpa.NamedEntityRepository;
import com.github.trks1970.common.infrastructure.repository.jpa.specification.TestNamedUuidEntitySpecification;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestNamedUuidEntityRepositoryImpl
    extends NamedEntityRepositoryBase<UUID, TestINamedUuid, TestNamedEntity>
    implements TestNamedUuidRepository {

  private final JpaTestNamedUuidEntityRepository jpaTestPersistentLongEntityRepository;
  private final TestNamedUuidEntityMapper testNamedUuidEntityMapper;

  @Override
  protected EntityMapper<UUID, TestINamedUuid, TestNamedEntity> mapper() {
    return testNamedUuidEntityMapper;
  }

  @Override
  @SuppressWarnings("unused")
  protected NotFoundException notFoundException(
      @Nullable UUID id,
      @Nullable IPersistent<UUID> type,
      @Nullable IPersistentEntity<UUID> entity) {
    return new NotFoundException(TestINamedUuid.class, "id " + id);
  }

  @Override
  protected Specification<TestNamedEntity> name(String name) {
    return TestNamedUuidEntitySpecification.name(name);
  }

  @Override
  protected NamedEntityRepository<TestNamedEntity, UUID, Long> repository() {
    return jpaTestPersistentLongEntityRepository;
  }
}
