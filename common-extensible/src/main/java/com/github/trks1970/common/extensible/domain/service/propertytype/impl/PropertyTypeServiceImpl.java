package com.github.trks1970.common.extensible.domain.service.propertytype.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.domain.service.impl.AbstractNamedTypeService;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.domain.service.propertytype.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PropertyTypeServiceImpl extends AbstractNamedTypeService<Long, IPropertyType<Long>>
    implements PropertyTypeService<Long, IPropertyType<Long>> {

  private final PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository;

  @Override
  protected NamedTypeRepository<Long, IPropertyType<Long>> repository() {
    return propertyTypeRepository;
  }
}
