package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.specification;

import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity_;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultPropertyValueEntitySpecification {

  public static Specification<DefaultPropertyValueEntity> name(String name) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(DefaultPropertyValueEntity_.NAME), name);
  }

  public static Specification<DefaultPropertyValueEntity> propertyType(Long propertyTypeId) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(DefaultPropertyValueEntity_.PROPERTY_TYPE), propertyTypeId);
  }

  public static Specification<DefaultPropertyValueEntity> propertyTypes(Set<Long> propertyTypeIds) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder
            .in(root.get(DefaultPropertyValueEntity_.PROPERTY_TYPE))
            .value(propertyTypeIds);
  }
}
