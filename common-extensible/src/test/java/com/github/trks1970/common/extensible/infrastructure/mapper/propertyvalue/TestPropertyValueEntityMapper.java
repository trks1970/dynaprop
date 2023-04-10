package com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.TestPropertyValue;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface TestPropertyValueEntityMapper
    extends EntityMapper<Long, TestPropertyValue, TestPropertyValueEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  TestPropertyValueEntity toEntity(TestPropertyValue type);

  @Override
  @Mapping(target = "revision", ignore = true)
  TestPropertyValueEntity toEntity(
      TestPropertyValue type, @MappingTarget TestPropertyValueEntity entity);
}
