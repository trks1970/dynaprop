package com.github.trks1970.common.infrastructure.repository;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.domain.model.Persistent;
import com.github.trks1970.common.domain.model.TestPersistentLong;
import com.github.trks1970.common.domain.repository.TestPersistentLongRepository;
import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import com.github.trks1970.common.infrastructure.entity.TestPersistentLongEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.mapper.TestPersistentLongEntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaTestPersistentLongEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPersistentLongEntityRepositoryImpl
    extends PersistentEntityRepositoryBase<Long, TestPersistentLong, TestPersistentLongEntity>
    implements TestPersistentLongRepository {

  private final JpaTestPersistentLongEntityRepository jpaTestPersistentLongEntityRepository;
  private final TestPersistentLongEntityMapper testPersistentLongEntityMapper;

  @Override
  protected JpaBaseRepository<TestPersistentLongEntity, Long, Long> repository() {
    return jpaTestPersistentLongEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestPersistentLong, TestPersistentLongEntity> mapper() {
    return testPersistentLongEntityMapper;
  }

  @Override
  @SuppressWarnings("unused")
  protected NotFoundException notFoundException(
      @Nullable Long id, @Nullable Persistent<Long> type, @Nullable PersistentEntity<Long> entity) {
    return new NotFoundException(TestPersistentLong.class, "id " + id);
  }
}
