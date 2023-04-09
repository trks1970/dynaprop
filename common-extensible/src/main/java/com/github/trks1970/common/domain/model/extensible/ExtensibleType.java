package com.github.trks1970.common.domain.model.extensible;

import com.github.trks1970.common.domain.model.Named;
import java.io.Serializable;
import java.util.Set;

public interface ExtensibleType<ID extends Serializable> extends Named<ID> {
  Set<ID> getPropertyTypeIds();
}
