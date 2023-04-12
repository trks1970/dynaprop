package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
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

  private final ExtensibleTypeRepository<Long, DefaultExtensibleType> extensibleTypeRepository;
  private final PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository;

  @Override
  protected NamedTypeRepository<Long, DefaultExtensibleType> repository() {
    return extensibleTypeRepository;
  }

  @Override
  protected PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository() {
    return propertyTypeRepository;
  }
}
