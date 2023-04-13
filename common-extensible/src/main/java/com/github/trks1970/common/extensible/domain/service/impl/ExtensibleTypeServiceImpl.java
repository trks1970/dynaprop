package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.domain.service.propertytype.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ExtensibleTypeServiceImpl
    extends AbstractExtensibleTypeService<Long, IPropertyType<Long>, DefaultExtensibleType> {

  private final ExtensibleTypeRepository<Long, IPropertyType<Long>, DefaultExtensibleType>
      extensibleTypeRepository;
  private final PropertyTypeService<Long, IPropertyType<Long>> propertyTypeService;

  @Override
  protected ExtensibleTypeRepository<Long, IPropertyType<Long>, DefaultExtensibleType>
      repository() {
    return extensibleTypeRepository;
  }

  @Override
  protected PropertyTypeService<Long, IPropertyType<Long>> propertyTypeService() {
    return propertyTypeService;
  }
}
