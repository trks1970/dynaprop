package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.domain.model.TestExtensibleType;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TestExtensibleTypeEntityMapper extends EntityMapper<Long, TestExtensibleType, TestExtensibleTypeEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  TestExtensibleTypeEntity toEntity(TestExtensibleType type);

  @Override
  @Mapping(target = "revision", ignore = true)
  TestExtensibleTypeEntity toEntity(TestExtensibleType type, @MappingTarget TestExtensibleTypeEntity entity);
}
