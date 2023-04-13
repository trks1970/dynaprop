package com.github.trks1970.common.extensible.domain.model;

import com.github.trks1970.common.domain.model.IPersistent;
import java.io.Serializable;
import java.util.Set;

public interface IExtensible<ID extends Serializable> extends IPersistent<ID> {
  ID getExtensibleTypeId();

  Set<ID> getPropertyValueIds();
}
