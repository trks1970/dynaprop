package com.github.trks1970.common.extensible.domain.model;

import com.github.trks1970.common.domain.model.Named;
import java.io.Serializable;

public interface ExtensibleType<ID extends Serializable> extends Named<ID> {}
