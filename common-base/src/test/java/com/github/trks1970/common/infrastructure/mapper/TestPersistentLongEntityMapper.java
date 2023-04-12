package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.TestIPersistentLong;
import com.github.trks1970.common.infrastructure.entity.TestIPersistentLongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TestPersistentLongEntityMapper
    extends EntityMapper<Long, TestIPersistentLong, TestIPersistentLongEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  TestIPersistentLongEntity toEntity(TestIPersistentLong type);

  @Override
  @Mapping(target = "revision", ignore = true)
  TestIPersistentLongEntity toEntity(
      TestIPersistentLong type, @MappingTarget TestIPersistentLongEntity entity);
}
