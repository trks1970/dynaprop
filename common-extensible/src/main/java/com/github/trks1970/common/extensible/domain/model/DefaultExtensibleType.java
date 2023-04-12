package com.github.trks1970.common.extensible.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
public class DefaultExtensibleType implements IExtensibleType<Long> {
  Long id;
  @NonNull @lombok.NonNull @EqualsAndHashCode.Include String name;
  String description;
}