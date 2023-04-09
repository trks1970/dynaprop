package com.github.trks1970.common.infrastructure.mapper;

import com.github.trks1970.common.domain.model.TestPersistentLong;
import com.github.trks1970.common.infrastructure.entity.TestPersistentLongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TestPersistentLongEntityMapper
    extends EntityMapper<Long, TestPersistentLong, TestPersistentLongEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  TestPersistentLongEntity toEntity(TestPersistentLong type);

  @Override
  @Mapping(target = "revision", ignore = true)
  TestPersistentLongEntity toEntity(
      TestPersistentLong type, @MappingTarget TestPersistentLongEntity entity);
}
