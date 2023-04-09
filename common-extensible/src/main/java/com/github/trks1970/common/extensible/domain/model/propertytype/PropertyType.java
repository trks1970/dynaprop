package com.github.trks1970.common.extensible.domain.model.propertytype;

import com.github.trks1970.common.domain.model.Named;
import java.io.Serializable;
import java.util.Set;

public interface PropertyType<ID extends Serializable> extends Named<ID> {
  Set<Long> getExtensibleTypeIds();

  PropertyTypes getPropertyType();
}
