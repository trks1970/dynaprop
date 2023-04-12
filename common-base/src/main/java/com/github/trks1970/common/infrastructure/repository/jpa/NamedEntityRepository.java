package com.github.trks1970.common.infrastructure.repository.jpa;

import com.github.trks1970.common.infrastructure.entity.IdProjection;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NamedEntityRepository<T, ID extends Serializable, R extends Number & Comparable<R>>
    extends JpaBaseRepository<T, ID, R> {
  Optional<IdProjection<ID>> findByName(String name);
}
