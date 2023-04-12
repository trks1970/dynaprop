package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import java.io.Serializable;

public interface IExtensibleTypeEntity<ID extends Serializable> extends INamedEntity<ID> {}
