package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultStringPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.DefaultExtensibleTypeReferenceMapper;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class DefaultStringPropertyTypeEntityMapper
    implements EntityMapper<Long, DefaultStringPropertyType, DefaultStringPropertyTypeEntity> {

  @Autowired private DefaultExtensibleTypeReferenceMapper defaultExtensibleTypeReferenceMapper;

  @Override
  @Mapping(target = "extensibleTypeId", source = "extensibleType.id")
  public abstract DefaultStringPropertyType toDomain(DefaultStringPropertyTypeEntity entity);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract DefaultStringPropertyTypeEntity toEntity(DefaultStringPropertyType type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract DefaultStringPropertyTypeEntity toEntity(
      DefaultStringPropertyType type, @MappingTarget DefaultStringPropertyTypeEntity entity);

  protected DefaultExtensibleTypeEntity mapExtensibleTypeId(Long extensibleTypeId) {
    return defaultExtensibleTypeReferenceMapper.map(extensibleTypeId);
  }
}
