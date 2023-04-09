package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.model.TestNamedUuid;
import com.github.trks1970.common.domain.repository.NamedTypeRepository;
import com.github.trks1970.common.domain.repository.TestNamedUuidRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TestNamedUuidService extends NamedTypeService<UUID, TestNamedUuid> {

  private final TestNamedUuidRepository repository;

  @Override
  protected NamedTypeRepository<UUID, TestNamedUuid> repository() {
    return repository;
  }

  public Optional<TestNamedUuid> findByUniqueName(@NonNull String name) {
    return repository.findByName(name).stream().findFirst();
  }
}
