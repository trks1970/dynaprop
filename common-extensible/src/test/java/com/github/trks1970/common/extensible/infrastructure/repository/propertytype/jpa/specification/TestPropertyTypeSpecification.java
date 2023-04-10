package com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestPropertyTypeSpecification {
  public static Specification<TestPropertyTypeEntity> name(String name) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(TestPropertyTypeEntity_.NAME), name);
  }

  public static Specification<TestPropertyTypeEntity> extensibleTypeId(Long extensibleTypeId) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(TestPropertyTypeEntity_.EXTENSIBLE_TYPE), extensibleTypeId);
  }
}
