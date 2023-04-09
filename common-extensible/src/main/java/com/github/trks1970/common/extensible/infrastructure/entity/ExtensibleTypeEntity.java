package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.infrastructure.entity.NamedEntity;
import java.io.Serializable;

public interface ExtensibleTypeEntity<ID extends Serializable> extends NamedEntity<ID> {}
