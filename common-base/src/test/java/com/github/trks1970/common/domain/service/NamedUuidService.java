package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.model.TestNamedUuid;
import java.util.Optional;
import java.util.UUID;
import org.springframework.lang.NonNull;

public interface NamedUuidService extends NamedTypeService<UUID, TestNamedUuid> {
  Optional<TestNamedUuid> findByUniqueName(@NonNull String name);
}
