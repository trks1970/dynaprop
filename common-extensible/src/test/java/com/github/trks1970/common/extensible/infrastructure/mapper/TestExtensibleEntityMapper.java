package com.github.trks1970.common.extensible.infrastructure.mapper;

import com.github.trks1970.common.extensible.domain.model.TestExtensible;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TestExtensibleEntityMapper
    implements EntityMapper<Long, TestExtensible, TestExtensibleEntity> {

  @Autowired private ExtensibleTypeReferenceMapper extensibleTypeReferenceMapper;

  @Override
  @Mapping(target = "extensibleTypeId", source = "extensibleType.id")
  public abstract TestExtensible toDomain(TestExtensibleEntity entity);

  protected TestExtensibleTypeEntity mapExtensibleTypeId(Long id) {
    return extensibleTypeReferenceMapper.map(id);
  }

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract TestExtensibleEntity toEntity(TestExtensible type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract TestExtensibleEntity toEntity(
      TestExtensible type, @MappingTarget TestExtensibleEntity entity);
}
