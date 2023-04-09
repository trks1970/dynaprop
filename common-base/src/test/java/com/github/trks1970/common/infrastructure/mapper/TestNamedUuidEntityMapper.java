package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.TestNamedUuid;
import com.github.trks1970.common.infrastructure.entity.TestNamedUuidEntity;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TestNamedUuidEntityMapper
    extends EntityMapper<UUID, TestNamedUuid, TestNamedUuidEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  TestNamedUuidEntity toEntity(TestNamedUuid type);

  @Override
  @Mapping(target = "revision", ignore = true)
  TestNamedUuidEntity toEntity(TestNamedUuid type, @MappingTarget TestNamedUuidEntity entity);
}
