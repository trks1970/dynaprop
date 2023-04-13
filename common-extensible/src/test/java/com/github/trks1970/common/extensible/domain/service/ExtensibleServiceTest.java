package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensible;
import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.IExtensible;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;

@SpringBootTest
class ExtensibleServiceTest {

  @Autowired ExtensibleService<Long, DefaultExtensible, IPropertyValue<Long>> extensibleService;

  @Autowired
  ExtensibleTypeService<Long, IPropertyType<Long>, DefaultExtensibleType> extensibleTypeService;

  @Nullable IPropertyType<Long> propertyType;
  @Nullable IExtensibleType<Long> extensibleType;
  @Nullable IExtensible<Long> extensible;

  @BeforeEach
  void setup() {}

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
