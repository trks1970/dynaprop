package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.TestPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.TestStringPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestStringPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPropertyTypeEntityMapper
    implements EntityMapper<Long, TestPropertyType, TestPropertyTypeEntity> {

  private final TestStringPropertyTypeEntityMapper testStringPropertyTypeEntityMapper;

  @Override
  public TestPropertyType toDomain(TestPropertyTypeEntity entity) {
    return switch (entity.getType()) {
      case STRING -> testStringPropertyTypeEntityMapper.toDomain(
          (TestStringPropertyTypeEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public TestPropertyTypeEntity toEntity(TestPropertyType type) {
    return switch (type.getType()) {
      case STRING -> testStringPropertyTypeEntityMapper.toEntity((TestStringPropertyType) type);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public TestPropertyTypeEntity toEntity(TestPropertyType type, TestPropertyTypeEntity entity) {
    return switch (type.getType()) {
      case STRING -> testStringPropertyTypeEntityMapper.toEntity(
          (TestStringPropertyType) type, (TestStringPropertyTypeEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }
}
