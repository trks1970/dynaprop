package com.github.trks1970.common.infrastructure.repository;

import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.domain.model.IPersistent;
import com.github.trks1970.common.domain.model.TestIPersistentLong;
import com.github.trks1970.common.domain.repository.TestPersistentLongRepository;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import com.github.trks1970.common.infrastructure.entity.TestIPersistentLongEntity;
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
    extends PersistentEntityRepositoryBase<Long, TestIPersistentLong, TestIPersistentLongEntity>
    implements TestPersistentLongRepository {

  private final JpaTestPersistentLongEntityRepository jpaTestPersistentLongEntityRepository;
  private final TestPersistentLongEntityMapper testPersistentLongEntityMapper;

  @Override
  protected JpaBaseRepository<Long, TestIPersistentLongEntity, Long> repository() {
    return jpaTestPersistentLongEntityRepository;
  }

  @Override
  protected EntityMapper<Long, TestIPersistentLong, TestIPersistentLongEntity> mapper() {
    return testPersistentLongEntityMapper;
  }

  @Override
  @SuppressWarnings("unused")
  protected NotFoundException notFoundException(
      @Nullable Long id,
      @Nullable IPersistent<Long> type,
      @Nullable IPersistentEntity<Long> entity) {
    return new NotFoundException(TestIPersistentLong.class, "id " + id);
  }
}
