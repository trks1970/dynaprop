package com.github.trks1970.common.infrastructure.repository.jpa.specification;

import com.github.trks1970.common.infrastructure.entity.TestNamedUuidEntity;
import com.github.trks1970.common.infrastructure.entity.TestNamedUuidEntity_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestNamedUuidEntitySpecification {
  public static Specification<TestNamedUuidEntity> name(String name) {
    return (root, query, criteriaBuilder) -> {
      return criteriaBuilder.equal(root.get(TestNamedUuidEntity_.NAME), name);
    };
  }
}
