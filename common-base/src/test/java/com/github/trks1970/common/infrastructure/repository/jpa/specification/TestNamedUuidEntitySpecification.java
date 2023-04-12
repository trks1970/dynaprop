package com.github.trks1970.common.infrastructure.repository.jpa.specification;

import com.github.trks1970.common.infrastructure.entity.TestNamedEntity;
import com.github.trks1970.common.infrastructure.entity.TestNamedEntity_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestNamedUuidEntitySpecification {
  public static Specification<TestNamedEntity> name(String name) {
    return (root, query, criteriaBuilder) -> {
      return criteriaBuilder.equal(root.get(TestNamedEntity_.NAME), name);
    };
  }
}
