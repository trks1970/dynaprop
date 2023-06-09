package com.github.trks1970.common.extensible.domain.model;

import com.github.trks1970.common.domain.model.INamed;
import java.io.Serializable;
import java.util.Set;

public interface IExtensibleType<ID extends Serializable> extends INamed<ID> {
  Set<ID> getPropertyTypeIds();
}
