package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.TestStringPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestStringPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.ExtensibleTypeReferenceMapper;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TestStringPropertyTypeEntityMapper
    implements EntityMapper<Long, TestStringPropertyType, TestStringPropertyTypeEntity> {

  @Autowired private ExtensibleTypeReferenceMapper extensibleTypeReferenceMapper;

  @Override
  @Mapping(target = "extensibleTypeId", source = "extensibleType.id")
  public abstract TestStringPropertyType toDomain(TestStringPropertyTypeEntity entity);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract TestStringPropertyTypeEntity toEntity(TestStringPropertyType type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensibleType", source = "extensibleTypeId")
  public abstract TestStringPropertyTypeEntity toEntity(
      TestStringPropertyType type, @MappingTarget TestStringPropertyTypeEntity entity);

  protected TestExtensibleTypeEntity mapExtensibleTypeId(Long extensibleTypeId) {
    return extensibleTypeReferenceMapper.map(extensibleTypeId);
  }
}
