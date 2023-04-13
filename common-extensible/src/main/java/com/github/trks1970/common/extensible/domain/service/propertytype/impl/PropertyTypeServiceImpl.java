package com.github.trks1970.common.extensible.domain.service.propertytype.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PropertyTypeServiceImpl extends AbstractPropertyTypeService<Long> {

  private final PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository;

  @Override
  protected NamedTypeRepository<Long, IPropertyType<Long>> repository() {
    return propertyTypeRepository;
  }

  @Override
  public Set<IPropertyType<Long>> getPropertyTypesOf(IExtensibleType<Long> extensibleType) {
    return getPropertyTypesOfExtensibleType(extensibleType.getId());
  }

  @Override
  public Set<IPropertyType<Long>> getPropertyTypesOfExtensibleType(Long extensibleTypeId) {
    return propertyTypeRepository.getPropertyTypesOfExtensibleType(extensibleTypeId);
  }
}
