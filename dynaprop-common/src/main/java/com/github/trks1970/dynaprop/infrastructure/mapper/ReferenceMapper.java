package com.github.trks1970.dynaprop.infrastructure.mapper;

import org.mapstruct.TargetType;

public interface ReferenceMapper {
  <T> T map(Long id, @TargetType Class<T> type);
}
