package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaNamedEntityRepository;
import java.io.Serializable;
import java.util.Set;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaPropertyTypeEntityRepository<
        ID extends Serializable, PTE extends IPropertyTypeEntity<ID>>
    extends JpaNamedEntityRepository<ID, PTE, Long> {
  Set<PTE> findByExtensibleTypeId(ID extensibleTypeId);
}
