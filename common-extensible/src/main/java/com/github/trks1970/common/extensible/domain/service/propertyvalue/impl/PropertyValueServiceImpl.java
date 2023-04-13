package com.github.trks1970.common.extensible.domain.service.propertyvalue.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.propertyvalue.PropertyValueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PropertyValueServiceImpl extends AbstractPropertyValueService<Long> {
  private final PropertyValueRepository<Long, IPropertyValue<Long>> propertyValueRepository;

  @Override
  protected NamedTypeRepository<Long, IPropertyValue<Long>> repository() {
    return propertyValueRepository;
  }
}
