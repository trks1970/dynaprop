package com.github.trks1970.common.extensible.domain.model.propertyvalue;

import com.github.trks1970.common.domain.model.INamed;
import com.github.trks1970.common.extensible.domain.model.Types;
import java.io.Serializable;

public interface IPropertyValue<ID extends Serializable> extends INamed<ID> {
  Object getValueObject();

  ID getExtensibleId();

  ID getPropertyTypeId();

  Types getType();
}
