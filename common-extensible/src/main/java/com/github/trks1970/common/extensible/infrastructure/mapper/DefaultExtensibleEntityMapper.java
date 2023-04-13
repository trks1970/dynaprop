package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensible;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

  @Autowired private DefaultExtensibleTypeReferenceMapper defaultExtensibleTypeReferenceMapper;

  @Override
  @Mapping(target = "extensibleTypeId", source = "extensibleType.id")
  public abstract DefaultExtensible toDomain(DefaultExtensibleEntity entity);

  protected @Nullable DefaultExtensibleTypeEntity mapExtensibleTypeId(Long id) {
    return defaultExtensibleTypeReferenceMapper.mapOptional(id);
  }

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract DefaultExtensibleEntity toEntity(DefaultExtensible type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract DefaultExtensibleEntity toEntity(
      DefaultExtensible type, @MappingTarget DefaultExtensibleEntity entity);
}
