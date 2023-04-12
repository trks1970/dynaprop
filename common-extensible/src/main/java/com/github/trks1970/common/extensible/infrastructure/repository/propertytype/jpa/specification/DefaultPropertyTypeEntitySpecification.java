package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultPropertyTypeEntitySpecification {

  public static Specification<DefaultPropertyTypeEntity> name(String name) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(DefaultPropertyTypeEntity_.NAME), name);
  }

  public static Specification<DefaultPropertyTypeEntity> extensibleTypeId(Long extensibleTypeId) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(
            root.get(DefaultPropertyTypeEntity_.EXTENSIBLE_TYPE), extensibleTypeId);
  }
}
