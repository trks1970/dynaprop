package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.infrastructure.entity.PersistentEntity;
import java.io.Serializable;

public interface ExtensibleEntity<ID extends Serializable, ET extends ExtensibleTypeEntity<ID>>
    extends PersistentEntity<ID> {

  ET getExtensibleType();
}
