package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.TestPropertyTypeRepository;
import com.github.trks1970.common.extensible.domain.service.TestPropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PropertyTypeServiceImpl implements TestPropertyTypeService {
  private final TestPropertyTypeRepository propertyTypeRepository;

  @Override
  public NamedTypeRepository<Long, TestPropertyType> repository() {
    return propertyTypeRepository;
  }
}
