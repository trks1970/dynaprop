package com.github.trks1970.common.extensible.domain.model.propertytype;

import com.github.trks1970.common.domain.model.INamed;
import com.github.trks1970.common.extensible.domain.model.Types;
import java.io.Serializable;

public interface IPropertyType<ID extends Serializable> extends INamed<ID> {
  ID getExtensibleTypeId();

  Types getType();
}
