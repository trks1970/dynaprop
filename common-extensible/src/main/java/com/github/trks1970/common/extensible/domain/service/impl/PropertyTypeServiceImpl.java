package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.domain.service.propertytype.PropertyTypeService;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@SuppressFBWarnings(
    value = {"EI_EXPOSE_REP", "EI_EXPOSE_REP2"},
    justification = "I prefer to suppress these FindBugs warnings")
public class PropertyTypeServiceImpl implements PropertyTypeService<Long, IPropertyType<Long>> {

  private final PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository;

  @Override
  public NamedTypeRepository<Long, IPropertyType<Long>> repository() {
    return propertyTypeRepository;
  }
}
