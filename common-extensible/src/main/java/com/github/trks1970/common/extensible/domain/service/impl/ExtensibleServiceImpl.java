package com.github.trks1970.common.extensible.domain.service.impl;

import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.extensible.domain.model.DefaultExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ExtensibleServiceImpl
    extends AbstractExtensibleService<Long, DefaultExtensible, IPropertyValue<Long>> {

  private final ExtensibleRepository<Long, DefaultExtensible> repository;

  @Override
  protected PersistentTypeRepository<Long, DefaultExtensible> repository() {
    return repository;
  }
}
