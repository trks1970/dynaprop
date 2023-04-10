package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.exception.IntegrityViolationException;
import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.repository.TestExtensibleTypeRepository;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.domain.repository.propertytype.TestPropertyTypeRepository;
import com.github.trks1970.common.extensible.domain.service.TestExtensibleTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ExtensibleTypeServiceImpl implements TestExtensibleTypeService {

  private final TestExtensibleTypeRepository extensibleTypeRepository;
  private final TestPropertyTypeRepository propertyTypeRepository;

  @Override
  public NamedTypeRepository<Long, TestExtensibleType> repository() {
    return extensibleTypeRepository;
  }

  @Override
  public PropertyTypeRepository<Long, TestPropertyType> propertyTypeRepository() {
    return propertyTypeRepository;
  }

  @Override
  public TestExtensibleType save(TestExtensibleType extensibleType) {
    if (isNameUnique(extensibleType)) {
      return TestExtensibleTypeService.super.save(extensibleType);
    }
    throw new IntegrityViolationException("TestExtensibleTypeName not unique: " + extensibleType);
  }
}
