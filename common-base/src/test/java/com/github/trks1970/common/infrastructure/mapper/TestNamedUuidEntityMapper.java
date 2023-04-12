package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.TestINamedUuid;
import com.github.trks1970.common.infrastructure.entity.TestNamedEntity;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TestNamedUuidEntityMapper
    extends EntityMapper<UUID, TestINamedUuid, TestNamedEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  TestNamedEntity toEntity(TestINamedUuid type);

  @Override
  @Mapping(target = "revision", ignore = true)
  TestNamedEntity toEntity(TestINamedUuid type, @MappingTarget TestNamedEntity entity);
}
