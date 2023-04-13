package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.io.Serializable;

public interface IExtensibleEntity<ID extends Serializable, ET extends IExtensibleTypeEntity<ID>>
    extends IPersistentEntity<ID> {

  ET getExtensibleType();

  IExtensibleEntity<ID, ET> setExtensibleType(ET extensibleType);
}
