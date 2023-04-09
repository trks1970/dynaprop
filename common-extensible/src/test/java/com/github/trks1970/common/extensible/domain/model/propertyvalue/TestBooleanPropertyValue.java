package com.github.trks1970.common.extensible.domain.model.propertyvalue;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class TestBooleanPropertyValue implements BooleanPropertyValue<Long> {

  Long id;
  @NonNull
  @lombok.NonNull
  @EqualsAndHashCode.Include
  String name;
  String description;
  @NonNull
  @lombok.NonNull
  @EqualsAndHashCode.Include
  Long propertyTypeId;
  @NonNull
  @lombok.NonNull
  @EqualsAndHashCode.Include
  Long extensibleId;
  @EqualsAndHashCode.Include
  Object valueObject;
}
