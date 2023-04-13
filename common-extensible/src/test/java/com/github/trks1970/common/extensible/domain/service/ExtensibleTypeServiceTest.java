package com.github.trks1970.common.extensible.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.trks1970.common.domain.exception.IntegrityViolationException;
import com.github.trks1970.common.domain.exception.NotFoundException;
import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleTypeEntityRepository;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ExtensibleTypeServiceTest {

  @Autowired
  ExtensibleTypeService<Long, IPropertyType<Long>, DefaultExtensibleType> extensibleTypeService;

  @Autowired
  ExtensibleTypeRepository<Long, IPropertyType<Long>, DefaultExtensibleType>
      extensibleTypeRepository;

  @Autowired JpaDefaultExtensibleTypeEntityRepository jpaExtensibleTypeRepository;

  IExtensibleType<Long> extensibleType;

  @BeforeEach
  void setup() {
    extensibleType =
        extensibleTypeService.save(DefaultExtensibleType.builder().name("extensibleType").build());
  }

  @AfterEach
  void tearDown() {
    extensibleTypeService.deleteById(extensibleType.getId());
  }

  @Test
  void testUpdate() {
    DefaultExtensibleType type = extensibleTypeService.findById(extensibleType.getId());

    type = type.toBuilder().name("newName").build();
    extensibleTypeService.save(type);

    DefaultExtensibleType found = extensibleTypeService.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  @Test
  void testDeleteById() {

    extensibleTypeService.deleteById(extensibleType.getId());
    assertThat(jpaExtensibleTypeRepository.findAll()).isEmpty();
  }

  @Test
  void testFindByName() {

    DefaultExtensibleType type =
        extensibleTypeService.findByName("extensibleType").stream()
            .findFirst()
            .orElseThrow(
                () -> new NotFoundException(DefaultExtensibleType.class, "name=[extensibleType]"));

    DefaultExtensibleType found = extensibleTypeService.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  @Test
  void testFindByNameNotFound() {
    assertThat(extensibleTypeService.findByName("someOtherName")).isEmpty();
  }

  @Test
  void testNameNotUnique() {
    assertThatThrownBy(
            () ->
                extensibleTypeService.save(
                    DefaultExtensibleType.builder().name("extensibleType").build()))
        .isInstanceOf(IntegrityViolationException.class);
  }

  @Test
  void testAddPropertyType() {
    IPropertyType<Long> propertyType =
        DefaultStringPropertyType.builder().name("propertyType").build();

    extensibleTypeService.addPropertyType(extensibleType.getId(), propertyType);
    Set<IPropertyType<Long>> propertyTypes =
        extensibleTypeService.getPropertyTypes(extensibleType.getId());

    assertThat(propertyTypes).containsExactly(propertyType);
  }

  @Test
  void testRemovePropertyType() {
    IPropertyType<Long> propertyType1 =
        DefaultStringPropertyType.builder().name("propertyType").build();
    IPropertyType<Long> propertyType2 =
        DefaultStringPropertyType.builder().name("otherPropertyType").build();
    propertyType1 = extensibleTypeService.addPropertyType(extensibleType.getId(), propertyType1);

    propertyType2 = extensibleTypeService.addPropertyType(extensibleType.getId(), propertyType2);

    extensibleTypeService.removePropertyType(extensibleType.getId(), propertyType1);
    Set<IPropertyType<Long>> propertyTypes =
        extensibleTypeService.getPropertyTypes(extensibleType.getId());

    assertThat(propertyTypes).containsExactly(propertyType2);
  }

  @Test
  void testDeleteWithPropertyType() {}
}
