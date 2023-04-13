package com.github.trks1970.common.extensible.domain.service.propertytype;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaDefaultPropertyTypeEntityRepository;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.util.Objects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;

@SpringBootTest
class PropertyTypeServiceTest {

  @Autowired PropertyTypeService<Long, IPropertyType<Long>> service;
  @Autowired PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository;
  @Autowired JpaDefaultPropertyTypeEntityRepository jpaPropertyTypeEntityRepository;
  @Autowired ExtensibleTypeRepository<Long, DefaultExtensibleType> extensibleTypeRepository;

  @Nullable DefaultExtensibleType extensibleType;

  @BeforeEach
  void setup() {
    extensibleType =
        extensibleTypeRepository.save(
            DefaultExtensibleType.builder().name("extensibleType").build());
  }

  @AfterEach
  void tearDown() {
    jpaPropertyTypeEntityRepository.findAll().stream()
        .map(IPersistentEntity::getId)
        .filter(Objects::nonNull)
        .forEach(id -> propertyTypeRepository.deleteById(id));
    assert extensibleType != null;
    extensibleTypeRepository.deleteById(extensibleType.getId());
  }

  @Test
  void testCreate() {
    IPropertyType<Long> type = getPropertyType();
    assertThat(type.getId()).isNull();
    type = service.save(type);

    assertThat(type.getId()).isNotNull();
  }

  @Test
  void testUpdate() {
    IPropertyType<Long> type = getPropertyType();
    type = service.save(type);

    type = ((DefaultStringPropertyType) type).toBuilder().name("newName").build();
    service.save(type);

    IPropertyType<Long> found = service.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  private IPropertyType<Long> getPropertyType() {
    assert Objects.requireNonNull(extensibleType).getId() != null;
    return DefaultStringPropertyType.builder()
        .name("propertyType")
        .extensibleTypeId(extensibleType.getId())
        .build();
  }
}
