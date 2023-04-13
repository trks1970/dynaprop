package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensible;
import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.service.propertytype.PropertyTypeService;
import com.github.trks1970.common.extensible.domain.service.propertyvalue.PropertyValueService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;

@SpringBootTest
class ExtensibleServiceTest {

  @Autowired ExtensibleService<Long, DefaultExtensible, IPropertyValue<Long>> extensibleService;
  @Autowired PropertyTypeService<Long, IPropertyType<Long>> propertyTypeService;

  @Autowired
  ExtensibleTypeService<Long, IPropertyType<Long>, DefaultExtensibleType> extensibleTypeService;

  @Autowired PropertyValueService<Long, IPropertyValue<Long>> propertyValueService;

  @Nullable IPropertyType<Long> propertyType;
  @Nullable IExtensibleType<Long> extensibleType;
  @Nullable IExtensible<Long> extensible;

  @BeforeEach
  void setup() {
    extensibleType =
        extensibleTypeService.save(DefaultExtensibleType.builder().name("extensibleType").build());
    propertyType =
        extensibleTypeService.addPropertyType(
            DefaultStringPropertyType.builder()
                .name("stringType")
                .extensibleTypeId(extensibleType.getId())
                .build());
    extensible =
        extensibleService.save(
            DefaultExtensible.builder().extensibleTypeId(extensibleType.getId()).build());
  }

  @AfterEach
  void tearDown() {
    assert extensibleType != null;
    extensibleTypeService.deleteById(extensibleType.getId());

    if (extensible != null) {
      extensibleService.deleteById(extensible.getId());
    }
  }

  @Test
  void addPropertyValue() {}

  @Test
  void removePropertyType() {}
}
