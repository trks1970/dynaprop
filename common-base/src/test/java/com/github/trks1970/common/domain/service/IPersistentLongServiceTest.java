package com.github.trks1970.common.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.TestJPAConfig;
import com.github.trks1970.common.domain.model.TestIPersistentLong;
import com.github.trks1970.common.domain.service.impl.PersistentLongServiceImpl;
import com.github.trks1970.common.infrastructure.mapper.TestPersistentLongEntityMapperImpl;
import com.github.trks1970.common.infrastructure.repository.TestPersistentLongEntityRepositoryImpl;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaTestPersistentLongEntityRepository;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
    classes = {
      TestJPAConfig.class,
      PersistentLongServiceImpl.class,
      TestPersistentLongEntityMapperImpl.class,
      TestPersistentLongEntityRepositoryImpl.class
    })
class IPersistentLongServiceTest {

  @Autowired PersistentLongService service;

  @Autowired JpaTestPersistentLongEntityRepository repository;

  @BeforeEach
  void setup() {
    repository.deleteAll();
  }

  @Test
  void create() {
    TestIPersistentLong persistent = service.save(TestIPersistentLong.builder().build());

    assertThat(persistent.getId()).isNotNull();
  }

  @Test
  void update() {
    TestIPersistentLong persistent =
        service.save(TestIPersistentLong.builder().value(true).build());

    TestIPersistentLong updated = service.save(persistent.toBuilder().value(false).build());

    assertThat(persistent.getId()).isEqualTo(updated.getId());
    assertThat(persistent.getValue()).isTrue();
    assertThat(updated.getValue()).isFalse();
  }

  @Test
  void findById() {
    TestIPersistentLong persistent =
        service.save(TestIPersistentLong.builder().value(true).build());

    TestIPersistentLong found = service.findById(persistent.getId());

    assertThat(found).usingRecursiveComparison().isEqualTo(persistent);
  }

  @Test
  void findAllById() {
    TestIPersistentLong persistent1 =
        service.save(TestIPersistentLong.builder().value(true).build());
    TestIPersistentLong persistent2 =
        service.save(TestIPersistentLong.builder().value(false).build());

    List<TestIPersistentLong> all =
        service.findAllById(Set.of(persistent1.getId(), persistent2.getId()));

    assertThat(all).containsExactlyInAnyOrder(persistent1, persistent2);
  }

  @Test
  void deleteById() {
    service.save(TestIPersistentLong.builder().value(true).build());
    TestIPersistentLong persistent2 =
        service.save(TestIPersistentLong.builder().value(false).build());

    service.deleteById(persistent2.getId());

    assertThat(repository.findAll()).hasSize(1);
  }
}
