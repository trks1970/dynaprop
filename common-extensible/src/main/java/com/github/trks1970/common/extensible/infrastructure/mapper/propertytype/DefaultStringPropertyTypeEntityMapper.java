package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultStringPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface DefaultStringPropertyTypeEntityMapper
    extends EntityMapper<Long, DefaultStringPropertyType, DefaultStringPropertyTypeEntity> {

  @Override
  DefaultStringPropertyType toDomain(DefaultStringPropertyTypeEntity entity);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", ignore = true)
  DefaultStringPropertyTypeEntity toEntity(DefaultStringPropertyType type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", ignore = true)
  DefaultStringPropertyTypeEntity toEntity(
      DefaultStringPropertyType type, @MappingTarget DefaultStringPropertyTypeEntity entity);
}
