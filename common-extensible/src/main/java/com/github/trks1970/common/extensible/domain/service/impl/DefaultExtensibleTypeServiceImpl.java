package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.domain.service.ExtensibleTypeService;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@SuppressFBWarnings(
    value = {"EI_EXPOSE_REP", "EI_EXPOSE_REP2"},
    justification = "I prefer to suppress these FindBugs warnings")
public class DefaultExtensibleTypeServiceImpl
    implements ExtensibleTypeService<Long, IPropertyType<Long>, DefaultExtensibleType> {

  private final ExtensibleTypeRepository<Long, DefaultExtensibleType> extensibleTypeRepository;
  private final PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository;

  @Override
  public NamedTypeRepository<Long, DefaultExtensibleType> repository() {
    return extensibleTypeRepository;
  }

  @Override
  public PropertyTypeRepository<Long, IPropertyType<Long>> propertyTypeRepository() {
    return propertyTypeRepository;
  }
}
