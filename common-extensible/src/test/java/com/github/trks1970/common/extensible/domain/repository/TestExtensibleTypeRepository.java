package com.github.trks1970.common.extensible.domain.repository;


import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.extensible.domain.model.TestExtensible;
import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;

public interface TestExtensibleTypeRepository extends
    ExtensibleTypeRepository<Long, TestPropertyType, TestExtensibleType> {

}
