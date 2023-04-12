package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.model.TestINamedUuid;
import java.util.Optional;
import java.util.UUID;
import org.springframework.lang.NonNull;

public interface NamedUuidService extends NamedTypeService<UUID, TestINamedUuid> {
  Optional<TestINamedUuid> findByUniqueName(@NonNull String name);
}
