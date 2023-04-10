package com.github.trks1970.common.extensible.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestStringPropertyTypeType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.TestPropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaTestPropertyTypeEntityRepository;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;

@SpringBootTest
public class PropertyTypeServiceTest {

  @Autowired TestPropertyTypeService service;
  @Autowired TestPropertyTypeRepository propertyTypeRepository;
  @Autowired JpaTestPropertyTypeEntityRepository jpaPropertyTypeEntityRepository;

  @Autowired JpaTestExtensibleTypeEntityRepository jpaExtensibleTypeRepository;

  @Nullable TestExtensibleTypeEntity extensibleType;

  @BeforeEach
  void setup() {
    jpaPropertyTypeEntityRepository.findAll().stream()
        .map(TestPropertyTypeEntity::getId)
        .filter(Objects::nonNull)
        .forEach(id -> propertyTypeRepository.deleteById(id));
    jpaExtensibleTypeRepository.deleteAll();
    extensibleType =
        jpaExtensibleTypeRepository.save(
            TestExtensibleTypeEntity.builder().name("extensibleType").build());
  }

  @Test
  void testCreate() {
    TestPropertyType type = getPropertyType();
    assertThat(type.getId()).isNull();
    type = service.save(type);

    assertThat(type.getId()).isNotNull();
  }

  @Test
  void testUpdate() {
    TestPropertyType type = getPropertyType();
    type = service.save(type);

    type = ((TestStringPropertyTypeType) type).toBuilder().name("newName").build();
    service.save(type);

    TestPropertyType found = service.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  private TestPropertyType getPropertyType() {
    assert Objects.requireNonNull(extensibleType).getId() != null;
    return TestStringPropertyTypeType.builder()
        .name("propertyType")
        .extensibleTypeId(extensibleType.getId())
        .build();
  }
}
