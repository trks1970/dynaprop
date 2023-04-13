package com.github.trks1970.common.infrastructure.repository.jpa;

import com.github.trks1970.common.infrastructure.entity.INamedEntity;
import com.github.trks1970.common.infrastructure.entity.IdProjection;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaNamedEntityRepository<
        ID extends Serializable, T extends INamedEntity<ID>, R extends Number & Comparable<R>>
    extends JpaBaseRepository<ID, T, R> {
  Optional<IdProjection<ID>> findIdByName(String name);
}
