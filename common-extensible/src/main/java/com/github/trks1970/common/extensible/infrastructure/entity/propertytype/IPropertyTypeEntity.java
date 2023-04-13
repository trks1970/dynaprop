package com.github.trks1970.common.extensible.infrastructure.entity.propertytype;

import com.github.trks1970.common.extensible.domain.model.Types;
import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import java.io.Serializable;

public interface IPropertyTypeEntity<ID extends Serializable> extends INamedEntity<ID> {
  Types getType();
}
