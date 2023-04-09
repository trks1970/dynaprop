package com.github.trks1970.common.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.TestJPAConfig;
import com.github.trks1970.common.domain.model.TestPersistentLong;
import com.github.trks1970.common.infrastructure.mapper.TestPersistentLongEntityMapperImpl;
import com.github.trks1970.common.infrastructure.repository.TestPersistentLongEntityRepositoryImpl;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaTestPersistentLongEntityRepository;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
    classes = {
      TestJPAConfig.class,
      TestPersistentLongService.class,
      TestPersistentLongEntityMapperImpl.class,
      TestPersistentLongEntityRepositoryImpl.class
    })
class PersistentLongServiceTest {

  @Autowired @Nullable TestPersistentLongService service = null;

  @Autowired @Nullable JpaTestPersistentLongEntityRepository repository;

  @BeforeEach
  void setup() {
    assert repository != null;
    repository.deleteAll();
  }

  @Test
  void create() {
    assert service != null;

    TestPersistentLong persistent = service.save(TestPersistentLong.builder().build());

    assertThat(persistent.getId()).isNotNull();
  }

  @Test
  void update() {
    assert service != null;

    TestPersistentLong persistent = service.save(TestPersistentLong.builder().value(true).build());

    TestPersistentLong updated = service.save(persistent.toBuilder().value(false).build());

    assertThat(persistent.getId()).isEqualTo(updated.getId());
    assertThat(persistent.getValue()).isTrue();
    assertThat(updated.getValue()).isFalse();
  }

  @Test
  void findById() {
    assert service != null;

    TestPersistentLong persistent = service.save(TestPersistentLong.builder().value(true).build());

    TestPersistentLong found = service.findById(persistent.getId());

    assertThat(found).usingRecursiveComparison().isEqualTo(persistent);
  }

  @Test
  void findAllById() {
    assert service != null;

    TestPersistentLong persistent1 = service.save(TestPersistentLong.builder().value(true).build());
    TestPersistentLong persistent2 =
        service.save(TestPersistentLong.builder().value(false).build());

    List<TestPersistentLong> all =
        service.findAllById(Set.of(persistent1.getId(), persistent2.getId()));

    assertThat(all).containsExactlyInAnyOrder(persistent1, persistent2);
  }

  @Test
  void deleteById() {
    assert service != null;
    assert repository != null;

    service.save(TestPersistentLong.builder().value(true).build());
    TestPersistentLong persistent2 =
        service.save(TestPersistentLong.builder().value(false).build());

    service.deleteById(persistent2.getId());

    assertThat(repository.findAll().size()).isEqualTo(1);
  }
}
