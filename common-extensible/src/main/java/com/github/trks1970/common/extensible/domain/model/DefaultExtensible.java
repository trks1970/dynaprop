package com.github.trks1970.common.extensible.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DefaultExtensible implements IExtensible<Long> {
  Long id;
  Long extensibleTypeId;
}
