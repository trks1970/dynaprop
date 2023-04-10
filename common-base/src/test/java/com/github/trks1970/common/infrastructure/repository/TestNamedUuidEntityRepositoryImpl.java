package com.github.trks1970.common.infrastructure.repository;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.domain.model.Persistent;
import com.github.trks1970.common.domain.model.TestNamedUuid;
import com.github.trks1970.common.domain.repository.TestNamedUuidRepository;
import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import com.github.trks1970.common.infrastructure.entity.TestNamedUuidEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.mapper.TestNamedUuidEntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaTestNamedUuidEntityRepository;
import com.github.trks1970.common.infrastructure.repository.jpa.specification.TestNamedUuidEntitySpecification;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestNamedUuidEntityRepositoryImpl
    extends NamedEntityRepositoryBase<UUID, TestNamedUuid, TestNamedUuidEntity>
    implements TestNamedUuidRepository {

  private final JpaTestNamedUuidEntityRepository jpaTestPersistentLongEntityRepository;
  private final TestNamedUuidEntityMapper testNamedUuidEntityMapper;

  @Override
  protected JpaBaseRepository<TestNamedUuidEntity, UUID, Long> repository() {
    return jpaTestPersistentLongEntityRepository;
  }

  @Override
  protected EntityMapper<UUID, TestNamedUuid, TestNamedUuidEntity> mapper() {
    return testNamedUuidEntityMapper;
  }

  @Override
  @SuppressWarnings("unused")
  protected NotFoundException notFoundException(
      @Nullable UUID id, @Nullable Persistent<UUID> type, @Nullable PersistentEntity<UUID> entity) {
    return new NotFoundException(TestNamedUuid.class, "id " + id);
  }

  @Override
  protected Specification<TestNamedUuidEntity> name(String name) {
    return TestNamedUuidEntitySpecification.name(name);
  }
}
