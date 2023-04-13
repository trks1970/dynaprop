package com.github.trks1970.common.extensible.domain.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class DefaultExtensible implements IExtensible<Long> {
  Long id;
  Long extensibleTypeId;
  @Builder.Default Set<Long> propertyValueIds = new HashSet<>();
}
