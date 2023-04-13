package com.github.trks1970.common.infrastructure.entity;

import com.github.trks1970.common.domain.model.IPersistent;
import java.io.Serializable;
import org.springframework.lang.Nullable;

public interface IPersistentEntity<ID extends Serializable> extends IPersistent<ID> {
  @Nullable
  Long getRevision();
}
