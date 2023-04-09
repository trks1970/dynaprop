package com.github.trks1970.common.extensible.domain.model.propertytype;

import com.github.trks1970.common.domain.model.Named;
import java.io.Serializable;

public interface PropertyType<ID extends Serializable> extends Named<ID> {
  ID getExtensibleTypeId();

  PropertyTypes getType();
}
