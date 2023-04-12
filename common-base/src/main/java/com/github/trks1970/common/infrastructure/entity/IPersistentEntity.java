package com.github.trks1970.common.infrastructure.entity;

import org.springframework.lang.Nullable;

public interface IPersistentEntity<ID> {
  @Nullable
  ID getId();

  @Nullable
  Long getRevision();
}
