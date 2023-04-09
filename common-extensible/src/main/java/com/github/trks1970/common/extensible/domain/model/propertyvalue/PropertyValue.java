package com.github.trks1970.common.extensible.domain.model.propertyvalue;

import com.github.trks1970.common.domain.model.Named;
import java.io.Serializable;

public interface PropertyValue<ID extends Serializable> extends Named<ID> {
  Long getPropertyTypeId();
}
