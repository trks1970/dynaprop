package com.github.trks1970.common.domain.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@Builder(toBuilder = true)
public class TestNamedUuid implements Named<UUID> {
  UUID id;
  @NonNull String name;
  String description;
}
