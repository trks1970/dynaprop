package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.domain.repository.TestExtensibleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestExtensibleTypeService extends ExtensibleTypeService<Long, TestExtensibleType> {

  private final TestExtensibleTypeRepository testExtensibleTypeRepository;

  @Override
  protected NamedTypeRepository<Long, TestExtensibleType> repository() {
    return testExtensibleTypeRepository;
  }
}
