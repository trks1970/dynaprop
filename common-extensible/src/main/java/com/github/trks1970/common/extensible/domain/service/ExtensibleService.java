package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.domain.service.PersistentTypeService;
import com.github.trks1970.common.extensible.domain.model.Extensible;
import java.io.Serializable;

public interface ExtensibleService<ID extends Serializable, E extends Extensible<ID>>
    extends PersistentTypeService<ID, E> {}
