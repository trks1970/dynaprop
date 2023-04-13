package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaNamedEntityRepository;
import java.io.Serializable;
import java.util.Set;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaPropertyTypeEntityRepository<
        ID extends Serializable,
        ETE extends IExtensibleTypeEntity<ID>,
        PTE extends IPropertyTypeEntity<ID, ETE>>
    extends JpaNamedEntityRepository<ID, PTE, Long> {
}
