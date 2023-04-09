package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TestPropertyTypeEntityMapper extends EntityMapper<Long, TestPropertyType, TestPropertyTypeEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  TestPropertyTypeEntity toEntity(TestPropertyType type);

  @Override
  @Mapping(target = "revision", ignore = true)
  TestPropertyTypeEntity toEntity(TestPropertyType type, @MappingTarget TestPropertyTypeEntity entity);
}
