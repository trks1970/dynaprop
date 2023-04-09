package com.github.trks1970.common.extensible.domain.service;

import com.github.trks1970.common.domain.model.Named;
import com.github.trks1970.common.domain.service.NamedTypeService;
import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional
public abstract class ExtensibleTypeService<ID extends Serializable, T extends Named<ID>> extends NamedTypeService<ID, T> {}
