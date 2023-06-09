package com.github.trks1970.common.infrastructure.repository.jpa;

import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.history.RevisionRepository;

@NoRepositoryBean
public interface JpaBaseRepository<
        ID extends Serializable, T extends IPersistentEntity<ID>, R extends Number & Comparable<R>>
    extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>, RevisionRepository<T, ID, R> {}
