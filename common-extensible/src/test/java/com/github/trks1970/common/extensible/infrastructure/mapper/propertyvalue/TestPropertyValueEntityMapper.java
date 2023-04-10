package com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.TestPropertyValue;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.TestStringPropertyValue;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.TestStringPropertyValueEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPropertyValueEntityMapper
    implements EntityMapper<Long, TestPropertyValue, TestPropertyValueEntity> {

  private final TestStringPropertyValueEntityMapper testStringPropertyValueEntityMapper;

  @Override
  public TestPropertyValue toDomain(TestPropertyValueEntity entity) {
    return switch (entity.getType()) {
      case STRING -> testStringPropertyValueEntityMapper.toDomain(
          (TestStringPropertyValueEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public TestPropertyValueEntity toEntity(TestPropertyValue type) {
    return switch (type.getType()) {
      case STRING -> testStringPropertyValueEntityMapper.toEntity((TestStringPropertyValue) type);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public TestPropertyValueEntity toEntity(TestPropertyValue type, TestPropertyValueEntity entity) {
    return switch (type.getType()) {
      case STRING -> testStringPropertyValueEntityMapper.toEntity(
          (TestStringPropertyValue) type, (TestStringPropertyValueEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }
}
