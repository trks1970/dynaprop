package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.domain.service.PersistentTypeService;
import com.github.trks1970.common.extensible.domain.model.Extensible;
import com.github.trks1970.common.extensible.domain.model.ExtensibleType;
import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional
public abstract class ExtensibleService<ID extends Serializable, E extends Extensible<ID>> extends PersistentTypeService<ID,E> {
}
