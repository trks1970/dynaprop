package com.github.trks1970.common.extensible.infrastructure.repository.jpa;

import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaPersistentEntityRepository;
import java.io.Serializable;
import java.util.Set;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaExtensibleEntityRepository<
        ID extends Serializable,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>>
    extends JpaPersistentEntityRepository<ID, EE, Long> {
}
