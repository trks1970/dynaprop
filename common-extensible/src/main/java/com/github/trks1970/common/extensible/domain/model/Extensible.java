package com.github.trks1970.common.extensible.domain.model;

import com.github.trks1970.common.domain.model.Persistent;
import java.io.Serializable;

public interface Extensible<ID extends Serializable> extends Persistent<ID> {
  ID getExtensibleTypeId();
}
