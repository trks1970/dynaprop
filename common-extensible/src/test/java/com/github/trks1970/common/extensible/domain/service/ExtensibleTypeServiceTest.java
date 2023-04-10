package com.github.trks1970.common.extensible.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trks1970.common.extensible.TestJPAConfig;
import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestStringPropertyType;
import com.github.trks1970.common.extensible.domain.repository.TestExtensibleTypeRepository;
import com.github.trks1970.common.extensible.domain.service.impl.ExtensibleTypeServiceImpl;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.ExtensibleTypeReferenceMapper;
import com.github.trks1970.common.extensible.infrastructure.mapper.TestExtensibleEntityMapperImpl;
import com.github.trks1970.common.extensible.infrastructure.mapper.TestExtensibleTypeEntityMapperImpl;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.TestPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.TestStringPropertyTypeEntityMapperImpl;
import com.github.trks1970.common.extensible.infrastructure.repository.TestExtensibleTypeRepositoryImpl;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaTestExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.TestPropertyTypeRepositoryImpl;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaTestPropertyTypeEntityRepository;
import java.util.Objects;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
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
      ExtensibleTypeServiceImpl.class,
      TestExtensibleTypeRepositoryImpl.class,
      TestPropertyTypeRepositoryImpl.class,
      TestExtensibleEntityMapperImpl.class,
      TestExtensibleTypeEntityMapperImpl.class,
      TestPropertyTypeEntityMapper.class,
      TestStringPropertyTypeEntityMapperImpl.class,
      ExtensibleTypeReferenceMapper.class
    })
@Slf4j
public class ExtensibleTypeServiceTest {

  @Autowired TestExtensibleTypeService service;
  @Autowired TestExtensibleTypeRepository extensibleTypeRepository;
  @Autowired JpaTestExtensibleTypeEntityRepository jpaExtensibleTypeRepository;
  @Autowired JpaTestPropertyTypeEntityRepository jpaPropertyTypeEntityRepository;

  @BeforeEach
  void setup() {
    jpaExtensibleTypeRepository.findAll().stream()
        .map(TestExtensibleTypeEntity::getId)
        .filter(Objects::nonNull)
        .forEach(id -> extensibleTypeRepository.deleteById(id));

    log.debug("BeforeEach entities {}", jpaExtensibleTypeRepository.findAll().size());
  }

  @Test
  void testCreate() {
    TestExtensibleType type = TestExtensibleType.builder().name("extensibleType").build();
    assertThat(type.getId()).isNull();
    type = service.save(type);

    assertThat(type.getId()).isNotNull();
  }

  @Test
  void testUpdate() {
    TestExtensibleType type = TestExtensibleType.builder().name("extensibleType").build();
    type = service.save(type);

    type = type.toBuilder().name("newName").build();
    service.save(type);

    TestExtensibleType found = service.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  @Test
  void testDeleteById() {
    TestExtensibleType type = TestExtensibleType.builder().name("extensibleType").build();

    type = service.save(type);

    service.deleteById(type.getId());

    assertThat(jpaExtensibleTypeRepository.findAll()).isEmpty();
  }

  @Test
  void testFindByName() {
    TestExtensibleType type = TestExtensibleType.builder().name("extensibleType").build();
    type = service.save(type);

    service.findByName("extensibleType");

    TestExtensibleType found = service.findById(type.getId());

    assertThat(type.getId()).isEqualTo(found.getId());
    assertThat(found.getName()).isEqualTo(type.getName());
  }

  @Test
  void testFindByNameNotFound() {
    assertThat(service.findByName("someOtherName")).isEmpty();
  }

  @Test
  void testAddPropertyType() {
    TestExtensibleType extensibleType =
        service.save(TestExtensibleType.builder().name("extensibleType").build());
    TestPropertyType propertyType =
        TestStringPropertyType.builder()
            .name("stringProperty")
            .extensibleTypeId(extensibleType.getId())
            .build();

    propertyType = service.addPropertyType(propertyType);
    Set<TestPropertyType> propertyTypes = service.getPropertyTypes(extensibleType.getId());

    assertThat(propertyType.getId()).isNotNull();
    assertThat(propertyTypes.size()).isEqualTo(1);
  }

  @Test
  void testRemovePropertyType() {
    TestExtensibleType extensibleType =
        service.save(TestExtensibleType.builder().name("extensibleType").build());
    TestPropertyType propertyType =
        TestStringPropertyType.builder()
            .name("stringProperty")
            .extensibleTypeId(extensibleType.getId())
            .build();
    propertyType = service.addPropertyType(propertyType);
    Set<TestPropertyType> propertyTypes = service.getPropertyTypes(extensibleType.getId());
    assertThat(propertyType.getId()).isNotNull();
    assertThat(propertyTypes.size()).isEqualTo(1);

    service.removePropertyType(propertyType);
    propertyTypes = service.getPropertyTypes(extensibleType.getId());
    assertThat(propertyTypes).isEmpty();
  }

  @Test
  void testDeleteWithPropertyType() {
    TestExtensibleType extensibleType = TestExtensibleType.builder().name("extensibleType").build();
    extensibleType = service.save(extensibleType);
    TestPropertyType propertyType =
        TestStringPropertyType.builder()
            .name("stringProperty")
            .extensibleTypeId(extensibleType.getId())
            .build();

    service.addPropertyType(propertyType);
    service.deleteById(extensibleType.getId());
  }
}
