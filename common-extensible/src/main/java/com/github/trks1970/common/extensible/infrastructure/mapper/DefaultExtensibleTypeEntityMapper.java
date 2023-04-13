package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.DefaultPropertyTypeReferenceMapper;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
@SuppressFBWarnings(
    value = "NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR",
    justification = "@Autowired")
public abstract class DefaultExtensibleTypeEntityMapper
    implements EntityMapper<Long, DefaultExtensibleType, DefaultExtensibleTypeEntity> {

  @Autowired private DefaultPropertyTypeReferenceMapper propertyTypeReferenceMapper;

  @Override
  @Mapping(target = "propertyTypeIds", source = "propertyTypes")
  public abstract DefaultExtensibleType toDomain(DefaultExtensibleTypeEntity entity);

  protected Set<Long> mapPropertyTypes(Set<DefaultPropertyTypeEntity> propertyTypes) {
    return propertyTypes.stream().map(DefaultPropertyTypeEntity::getId).collect(Collectors.toSet());
  }

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "propertyTypes", source = "propertyTypeIds")
  public abstract DefaultExtensibleTypeEntity toEntity(DefaultExtensibleType type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "propertyTypes", source = "propertyTypeIds")
  public abstract DefaultExtensibleTypeEntity toEntity(
      DefaultExtensibleType type, @MappingTarget DefaultExtensibleTypeEntity entity);

  Set<DefaultPropertyTypeEntity> mapPropertyTypeIds(Set<Long> propertyTypeIds) {
    return propertyTypeIds.stream()
        .map(id -> propertyTypeReferenceMapper.mapRequired(id))
        .collect(Collectors.toSet());
  }
}
