package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensible;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue.DefaultPropertyValueReferenceMapper;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

@Mapper
@SuppressFBWarnings(
    value = "NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR",
    justification = "@Autowired")
public abstract class DefaultExtensibleEntityMapper
    implements EntityMapper<Long, DefaultExtensible, DefaultExtensibleEntity> {

  @Autowired private DefaultExtensibleTypeReferenceMapper extensibleTypeReferenceMapper;
  @Autowired private DefaultPropertyValueReferenceMapper propertyValueReferenceMapper;

  @Override
  @Mapping(target = "extensibleTypeId", source = "extensibleType.id")
  @Mapping(target = "propertyValueIds", source = "propertyValues")
  public abstract DefaultExtensible toDomain(DefaultExtensibleEntity entity);

  protected Set<Long> mapPropertyValues(Set<DefaultPropertyValueEntity> propertyValues) {
    return propertyValues.stream()
        .map(DefaultPropertyValueEntity::getId)
        .collect(Collectors.toSet());
  }

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  @Mapping(target = "propertyValues", source = "propertyValueIds")
  public abstract DefaultExtensibleEntity toEntity(DefaultExtensible type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  @Mapping(target = "propertyValues", source = "propertyValueIds")
  public abstract DefaultExtensibleEntity toEntity(
      DefaultExtensible type, @MappingTarget DefaultExtensibleEntity entity);

  protected @Nullable DefaultExtensibleTypeEntity mapExtensibleTypeId(Long id) {
    return extensibleTypeReferenceMapper.mapOptional(id);
  }

  protected Set<DefaultPropertyValueEntity> mapPropertyValueIds(Set<Long> propertyValueIds) {
    return propertyValueIds.stream()
        .map(id -> propertyValueReferenceMapper.mapRequired(id))
        .collect(Collectors.toSet());
  }
}
