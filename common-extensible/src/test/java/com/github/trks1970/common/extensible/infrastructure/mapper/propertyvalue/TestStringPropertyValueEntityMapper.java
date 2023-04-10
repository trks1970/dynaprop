package com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.TestStringPropertyValue;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestStringPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.ExtensibleReferenceMapper;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.PropertyTypeReferenceMapper;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TestStringPropertyValueEntityMapper
    implements EntityMapper<Long, TestStringPropertyValue, TestStringPropertyValueEntity> {

  @Autowired private PropertyTypeReferenceMapper propertyTypeReferenceMapper;
  @Autowired private ExtensibleReferenceMapper extensibleReferenceMapper;

  @Override
  @Mapping(target = "propertyTypeId", source = "propertyType.id")
  @Mapping(target = "extensibleId", source = "extensible.id")
  public abstract TestStringPropertyValue toDomain(TestStringPropertyValueEntity entity);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensible", source = "extensibleId")
  @Mapping(target = "propertyType", source = "propertyTypeId")
  public abstract TestStringPropertyValueEntity toEntity(TestStringPropertyValue type);

  @Override
  @Mapping(target = "revision", ignore = true)
  @Mapping(target = "extensible", source = "extensibleId")
  @Mapping(target = "propertyType", source = "propertyTypeId")
  public abstract TestStringPropertyValueEntity toEntity(
      TestStringPropertyValue type, @MappingTarget TestStringPropertyValueEntity entity);

  protected String mapValueObject(Object valueObject) {
    return valueObject.toString();
  }

  protected TestExtensibleEntity mapExtensibleEntity(Long id) {
    return extensibleReferenceMapper.map(id);
  }

  protected TestPropertyTypeEntity mapPropertyType(Long id) {
    return propertyTypeReferenceMapper.map(id);
  }
}
