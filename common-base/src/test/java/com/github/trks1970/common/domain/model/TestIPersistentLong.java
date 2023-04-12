package com.github.trks1970.common.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TestIPersistentLong implements IPersistent<Long> {
  Long id;
  Boolean value;
}
