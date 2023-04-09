package com.github.trks1970.common.extensible.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TestExtensible implements Extensible<Long> {
  Long id;
  Long extensibleTypeId;
}