package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface DefaultExtensibleTypeEntityMapper
    extends EntityMapper<Long, DefaultExtensibleType, DefaultExtensibleTypeEntity> {

  @Override
  @Mapping(target = "revision", ignore = true)
  DefaultExtensibleTypeEntity toEntity(DefaultExtensibleType type);

  @Override
  @Mapping(target = "revision", ignore = true)
  DefaultExtensibleTypeEntity toEntity(
      DefaultExtensibleType type, @MappingTarget DefaultExtensibleTypeEntity entity);
}
