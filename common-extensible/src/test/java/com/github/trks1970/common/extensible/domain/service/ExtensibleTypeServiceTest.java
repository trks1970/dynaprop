package com.github.trks1970.common.extensible.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.trks1970.common.domain.exception.IntegrityViolationException;
import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaDefaultPropertyTypeEntityEntityRepository;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExtensibleTypeServiceTest {

  @Autowired ExtensibleTypeService<Long, IPropertyType<Long>, DefaultExtensibleType> service;
  @Autowired ExtensibleTypeRepository<Long, DefaultExtensibleType> extensibleTypeRepository;
  @Autowired JpaDefaultExtensibleTypeEntityRepository jpaExtensibleTypeRepository;
  @Autowired JpaDefaultPropertyTypeEntityEntityRepository jpaPropertyTypeEntityRepository;

  @BeforeEach
  void setup() {
    jpaExtensibleTypeRepository.findAll().stream()
        .map(DefaultExtensibleTypeEntity::getId)
        .filter(Objects::nonNull)
        .forEach(id -> extensibleTypeRepository.deleteById(id));
  }

  @Test
  void testCreate() {
    DefaultExtensibleType type = DefaultExtensibleType.builder().name("extensibleType").build();
    assertThat(type.getId()).isNull();
    type = service.save(type);

    assertThat(type.getId()).isNotNull();
  }

  @Test
  void testUpdate() {
    DefaultExtensibleType type = DefaultExtensibleType.builder().name("extensibleType").build();
    type = service.save(type);

    type = type.toBuilder().name("newName").build();
    service.save(type);

    DefaultExtensibleType found = service.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  @Test
  void testDeleteById() {
    DefaultExtensibleType type = DefaultExtensibleType.builder().name("extensibleType").build();

    type = service.save(type);

    service.deleteById(type.getId());

    assertThat(jpaExtensibleTypeRepository.findAll()).isEmpty();
  }

  @Test
  void testFindByName() {
    DefaultExtensibleType type = DefaultExtensibleType.builder().name("extensibleType").build();
    type = service.save(type);

    service.findByName("extensibleType");

    DefaultExtensibleType found = service.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  @Test
  void testFindByNameNotFound() {
    assertThat(service.findByName("someOtherName")).isEmpty();
  }

  @Test
  void testAddPropertyType() {
    DefaultExtensibleType extensibleType =
        service.save(DefaultExtensibleType.builder().name("extensibleType").build());
    IPropertyType<Long> propertyType =
        DefaultStringPropertyType.builder()
            .name("stringProperty")
            .extensibleTypeId(extensibleType.getId())
            .build();

    propertyType = service.addPropertyType(propertyType);
    Set<IPropertyType<Long>> propertyTypes = service.getPropertyTypes(extensibleType.getId());

    assertThat(propertyType.getId()).isNotNull();
    assertThat(propertyTypes.size()).isEqualTo(1);
  }

  @Test
  void testRemovePropertyType() {
    DefaultExtensibleType extensibleType =
        service.save(DefaultExtensibleType.builder().name("extensibleType").build());
    IPropertyType<Long> propertyType =
        DefaultStringPropertyType.builder()
            .name("stringProperty")
            .extensibleTypeId(extensibleType.getId())
            .build();
    propertyType = service.addPropertyType(propertyType);
    Set<IPropertyType<Long>> propertyTypes = service.getPropertyTypes(extensibleType.getId());
    assertThat(propertyType.getId()).isNotNull();
    assertThat(propertyTypes.size()).isEqualTo(1);

    service.removePropertyType(propertyType);
    propertyTypes = service.getPropertyTypes(extensibleType.getId());
    assertThat(propertyTypes).isEmpty();
  }

  @Test
  void testDeleteWithPropertyType() {
    DefaultExtensibleType extensibleType =
        DefaultExtensibleType.builder().name("extensibleType").build();
    extensibleType = service.save(extensibleType);
    IPropertyType<Long> propertyType1 =
        DefaultStringPropertyType.builder()
            .name("stringProperty")
            .extensibleTypeId(extensibleType.getId())
            .build();
    IPropertyType<Long> propertyType2 =
        DefaultStringPropertyType.builder()
            .name("stringProperty2")
            .extensibleTypeId(extensibleType.getId())
            .build();

    service.addPropertyType(propertyType1);
    service.addPropertyType(propertyType2);
    service.deleteById(extensibleType.getId());
  }

  @Test
  void testNameNotUnique() {
    service.save(DefaultExtensibleType.builder().name("extensibleType").build());
    assertThatThrownBy(
            () -> service.save(DefaultExtensibleType.builder().name("extensibleType").build()))
        .isInstanceOf(IntegrityViolationException.class);
  }
}
