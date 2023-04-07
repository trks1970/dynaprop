package com.github.trks1970.dynaprop.infrastructure.entity;

import org.springframework.lang.Nullable;

public interface PersistentEntity {
  @Nullable
  Long getId();
  @Nullable
  Long getRevision();
}
