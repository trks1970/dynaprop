package com.github.trks1970.common.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.TestJPAConfig;
import com.github.trks1970.common.domain.model.TestNamedUuid;
import com.github.trks1970.common.domain.service.impl.NamedUuidServiceImpl;
import com.github.trks1970.common.infrastructure.mapper.TestNamedUuidEntityMapperImpl;
import com.github.trks1970.common.infrastructure.repository.TestNamedUuidEntityRepositoryImpl;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaTestNamedUuidEntityRepository;
import java.util.List;
import java.util.Optional;
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
      NamedUuidServiceImpl.class,
      TestNamedUuidEntityMapperImpl.class,
      TestNamedUuidEntityRepositoryImpl.class
    })
class NamedUuidServiceTest {

  @Autowired NamedUuidService service;

  @Autowired JpaTestNamedUuidEntityRepository repository;

  @BeforeEach
  void setup() {
    repository.deleteAll();
  }

  @Test
  void create() {

    TestNamedUuid persistent = service.save(TestNamedUuid.builder().name("persistent").build());

    assertThat(persistent.getId()).isNotNull();
  }

  @Test
  void update() {
    TestNamedUuid persistent = service.save(TestNamedUuid.builder().name("persistent").build());

    TestNamedUuid updated = service.save(persistent.toBuilder().name("updated").build());

    assertThat(persistent.getId()).isEqualTo(updated.getId());
    assertThat(persistent.getName()).isEqualTo("persistent");
    assertThat(updated.getName()).isEqualTo("updated");
  }

  @Test
  void findById() {
    TestNamedUuid persistent = service.save(TestNamedUuid.builder().name("persistent").build());

    TestNamedUuid found = service.findById(persistent.getId());

    assertThat(found).usingRecursiveComparison().isEqualTo(persistent);
  }

  @Test
  void findAllById() {
    TestNamedUuid persistent1 = service.save(TestNamedUuid.builder().name("persistent1").build());
    TestNamedUuid persistent2 = service.save(TestNamedUuid.builder().name("persistent2").build());

    List<TestNamedUuid> all = service.findAllById(Set.of(persistent1.getId(), persistent2.getId()));

    assertThat(all).containsExactlyInAnyOrder(persistent1, persistent2);
  }

  @Test
  void deleteById() {
    service.save(TestNamedUuid.builder().name("persistent1").build());
    TestNamedUuid persistent2 = service.save(TestNamedUuid.builder().name("persistent2").build());

    service.deleteById(persistent2.getId());

    assertThat(repository.findAll()).hasSize(1);
  }

  @Test
  void findByName() {
    TestNamedUuid persistent = service.save(TestNamedUuid.builder().name("persistent1").build());

    Set<TestNamedUuid> found = service.findByName("persistent1");

    assertThat(found).hasSize(1);
    assertThat(found.iterator().next()).usingRecursiveComparison().isEqualTo(persistent);
  }

  @Test
  void findByNameNotFound() {
    service.save(TestNamedUuid.builder().name("persistent1").build());

    Set<TestNamedUuid> found = service.findByName("persistent2");

    assertThat(found).isEmpty();
  }

  @Test
  void findByUniqueName() {
    service.save(TestNamedUuid.builder().name("persistent1").build());

    Optional<TestNamedUuid> found = service.findByUniqueName("persistent1");

    assertThat(found).isPresent();
  }
}
