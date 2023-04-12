package com.github.trks1970.common.extensible.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.TestPropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaDefaultPropertyTypeEntityRepository;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;

@SpringBootTest
public class IPropertyTypeServiceTest {

  @Autowired TestPropertyTypeService service;
  @Autowired TestPropertyTypeRepository propertyTypeRepository;
  @Autowired JpaDefaultPropertyTypeEntityRepository jpaPropertyTypeEntityRepository;

  @Autowired JpaDefaultExtensibleTypeEntityRepository jpaExtensibleTypeRepository;

  @Nullable DefaultExtensibleTypeEntity extensibleType;

  @BeforeEach
  void setup() {
    jpaPropertyTypeEntityRepository.findAll().stream()
        .map(IPersistentEntity::getId)
        .filter(Objects::nonNull)
        .forEach(id -> propertyTypeRepository.deleteById(id));
    jpaExtensibleTypeRepository.deleteAll();
    extensibleType =
        jpaExtensibleTypeRepository.save(
            DefaultExtensibleTypeEntity.builder().name("extensibleType").build());
  }

  @Test
  void testCreate() {
    TestIPropertyType type = getPropertyType();
    assertThat(type.getId()).isNull();
    type = service.save(type);

    assertThat(type.getId()).isNotNull();
  }

  @Test
  void testUpdate() {
    TestIPropertyType type = getPropertyType();
    type = service.save(type);

    type = ((DefaultStringPropertyType) type).toBuilder().name("newName").build();
    service.save(type);

    TestIPropertyType found = service.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  private TestIPropertyType getPropertyType() {
    assert Objects.requireNonNull(extensibleType).getId() != null;
    return DefaultStringPropertyType.builder()
        .name("propertyType")
        .extensibleTypeId(extensibleType.getId())
        .build();
  }
}
