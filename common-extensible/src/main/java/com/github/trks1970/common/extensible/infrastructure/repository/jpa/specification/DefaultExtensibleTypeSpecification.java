package com.github.trks1970.common.extensible.infrastructure.repository.jpa.specification;

import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultExtensibleTypeSpecification {
  public static Specification<DefaultExtensibleTypeEntity> name(String name) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(DefaultExtensibleTypeEntity_.NAME), name);
  }
}
