package com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.DefaultStringPropertyValue;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultStringPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.DefaultExtensibleReferenceMapper;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.DefaultPropertyTypeReferenceMapper;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TestStringPropertyValueEntityMapper
    implements EntityMapper<Long, DefaultStringPropertyValue, DefaultStringPropertyValueEntity> {

  @Autowired private DefaultPropertyTypeReferenceMapper defaultPropertyTypeReferenceMapper;
  @Autowired private DefaultExtensibleReferenceMapper defaultExtensibleReferenceMapper;

  @Override
  @Mapping(target = "propertyTypeId", source = "propertyType.id")
  @Mapping(target = "extensibleId", source = "extensible.id")
  public abstract DefaultStringPropertyValue toDomain(DefaultStringPropertyValueEntity entity);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensible", source = "extensibleId")
  @Mapping(target = "propertyType", source = "propertyTypeId")
  public abstract DefaultStringPropertyValueEntity toEntity(DefaultStringPropertyValue type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensible", source = "extensibleId")
  @Mapping(target = "propertyType", source = "propertyTypeId")
  public abstract DefaultStringPropertyValueEntity toEntity(
      DefaultStringPropertyValue type, @MappingTarget DefaultStringPropertyValueEntity entity);

  protected String mapValueObject(Object valueObject) {
    return valueObject.toString();
  }

  protected DefaultExtensibleEntity mapExtensibleEntity(Long id) {
    return defaultExtensibleReferenceMapper.map(id);
  }

  protected DefaultPropertyTypeEntity mapPropertyType(Long id) {
    return defaultPropertyTypeReferenceMapper.map(id);
  }
}
