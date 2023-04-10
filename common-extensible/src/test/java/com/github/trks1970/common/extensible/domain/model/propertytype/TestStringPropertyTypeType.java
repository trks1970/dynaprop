package com.github.trks1970.common.extensible.domain.model.propertytype;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
public class TestStringPropertyTypeType implements TestPropertyType, StringPropertyType<Long> {
  Long id;
  @NonNull @lombok.NonNull @EqualsAndHashCode.Include String name;
  String description;
  @NonNull @lombok.NonNull @EqualsAndHashCode.Include Long extensibleTypeId;
}
