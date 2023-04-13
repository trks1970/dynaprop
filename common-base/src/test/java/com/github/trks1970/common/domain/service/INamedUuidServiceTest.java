package com.github.trks1970.common.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.TestJPAConfig;
import com.github.trks1970.common.domain.model.TestINamedUuid;
import com.github.trks1970.common.domain.service.impl.NamedUuidServiceImpl;
import com.github.trks1970.common.infrastructure.mapper.TestNamedUuidEntityMapperImpl;
import com.github.trks1970.common.infrastructure.repository.TestNamedUuidEntityRepositoryImpl;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaTestJpaNamedUuidEntityRepository;
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
class INamedUuidServiceTest {

  @Autowired NamedUuidService service;

  @Autowired JpaTestJpaNamedUuidEntityRepository repository;

  @BeforeEach
  void setup() {
    repository.deleteAll();
  }

  @Test
  void create() {

    TestINamedUuid persistent = service.save(TestINamedUuid.builder().name("persistent").build());

    assertThat(persistent.getId()).isNotNull();
  }

  @Test
  void update() {
    TestINamedUuid persistent = service.save(TestINamedUuid.builder().name("persistent").build());

    TestINamedUuid updated = service.save(persistent.toBuilder().name("updated").build());

    assertThat(persistent.getId()).isEqualTo(updated.getId());
    assertThat(persistent.getName()).isEqualTo("persistent");
    assertThat(updated.getName()).isEqualTo("updated");
  }

  @Test
  void findById() {
    TestINamedUuid persistent = service.save(TestINamedUuid.builder().name("persistent").build());

    TestINamedUuid found = service.findById(persistent.getId());

    assertThat(found).usingRecursiveComparison().isEqualTo(persistent);
  }

  @Test
  void findAllById() {
    TestINamedUuid persistent1 = service.save(TestINamedUuid.builder().name("persistent1").build());
    TestINamedUuid persistent2 = service.save(TestINamedUuid.builder().name("persistent2").build());

    List<TestINamedUuid> all =
        service.findAllById(Set.of(persistent1.getId(), persistent2.getId()));

    assertThat(all).containsExactlyInAnyOrder(persistent1, persistent2);
  }

  @Test
  void deleteById() {
    service.save(TestINamedUuid.builder().name("persistent1").build());
    TestINamedUuid persistent2 = service.save(TestINamedUuid.builder().name("persistent2").build());

    service.deleteById(persistent2.getId());

    assertThat(repository.findAll()).hasSize(1);
  }

  @Test
  void findByName() {
    TestINamedUuid persistent = service.save(TestINamedUuid.builder().name("persistent1").build());

    Set<TestINamedUuid> found = service.findByName("persistent1");

    assertThat(found).hasSize(1);
    assertThat(found.iterator().next()).usingRecursiveComparison().isEqualTo(persistent);
  }

  @Test
  void findByNameNotFound() {
    service.save(TestINamedUuid.builder().name("persistent1").build());

    Set<TestINamedUuid> found = service.findByName("persistent2");

    assertThat(found).isEmpty();
  }

  @Test
  void findByUniqueName() {
    service.save(TestINamedUuid.builder().name("persistent1").build());

    Optional<TestINamedUuid> found = service.findByUniqueName("persistent1");

    assertThat(found).isPresent();
  }
}
