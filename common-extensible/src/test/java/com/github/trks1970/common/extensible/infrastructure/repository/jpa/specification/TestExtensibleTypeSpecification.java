package com.github.trks1970.common.extensible.infrastructure.repository.jpa.specification;

import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestExtensibleTypeSpecification {
  public static Specification<TestExtensibleTypeEntity> name(String name) {
    return (root, query, criteriaBuilder) -> {
      return criteriaBuilder.equal(root.get(TestExtensibleTypeEntity_.NAME), name);
    };
  }
}
