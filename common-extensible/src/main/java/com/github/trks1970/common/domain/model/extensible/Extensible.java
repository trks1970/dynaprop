package com.github.trks1970.common.domain.model.extensible;

import com.github.trks1970.common.domain.model.Persistent;
import com.github.trks1970.common.domain.model.extensible.propertyvalue.PropertyValue;
import java.io.Serializable;
import java.util.Set;

public interface Extensible<ID extends Serializable, P extends PropertyValue<ID>>
    extends Persistent<ID> {
  Long getExtensibleTypeId();

  Set<P> getPropertyValues();
}
