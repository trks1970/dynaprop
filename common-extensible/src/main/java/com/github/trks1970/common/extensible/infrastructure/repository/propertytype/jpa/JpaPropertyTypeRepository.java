package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.entity.IdProjection;
import com.github.trks1970.common.infrastructure.repository.jpa.NamedEntityRepository;
import java.io.Serializable;
import java.util.Set;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaPropertyTypeRepository<
        ID extends Serializable,
        T extends IExtensibleTypeEntity<ID>,
        E extends IPropertyTypeEntity<ID, T>>
    extends NamedEntityRepository<E, ID, Long> {
  Set<IdProjection<ID>> findIdByExtensibleTypeId(ID extensibleTypeId);
}
