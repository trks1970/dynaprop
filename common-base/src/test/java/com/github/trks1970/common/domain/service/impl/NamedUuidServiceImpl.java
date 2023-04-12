package com.github.trks1970.common.domain.service.impl;

import com.github.trks1970.common.domain.model.TestINamedUuid;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.domain.repository.TestNamedUuidRepository;
import com.github.trks1970.common.domain.service.NamedUuidService;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NamedUuidServiceImpl extends AbstractNamedTypeService<UUID, TestINamedUuid>
    implements NamedUuidService {

  private final TestNamedUuidRepository repository;

  @Override
  public NamedTypeRepository<UUID, TestINamedUuid> repository() {
    return repository;
  }

  public Optional<TestINamedUuid> findByUniqueName(@NonNull String name) {
    return repository.findByName(name).stream().findFirst();
  }
}
