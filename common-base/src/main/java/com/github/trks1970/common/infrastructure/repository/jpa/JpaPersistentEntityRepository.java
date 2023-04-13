package com.github.trks1970.common.infrastructure.repository.jpa;

import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.io.Serializable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaPersistentEntityRepository<
        ID extends Serializable, T extends IPersistentEntity<ID>, R extends Number & Comparable<R>>
    extends JpaBaseRepository<ID, T, R> {}
