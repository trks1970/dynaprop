package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.specification;

import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity_;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestPropertyValueSpecification {
  public static Specification<TestPropertyValueEntity> name(String name) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(TestPropertyValueEntity_.NAME), name);
  }

  public static Specification<TestPropertyValueEntity> propertyType(Long propertyTypeId) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(TestPropertyValueEntity_.PROPERTY_TYPE), propertyTypeId);
  }

  public static Specification<TestPropertyValueEntity> propertyTypes(Set<Long> propertyTypeIds) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.in(root.get(TestPropertyValueEntity_.PROPERTY_TYPE)).value(propertyTypeIds);
  }
}
