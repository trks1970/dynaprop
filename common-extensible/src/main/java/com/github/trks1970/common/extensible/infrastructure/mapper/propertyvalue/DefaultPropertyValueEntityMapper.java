package com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.DefaultStringPropertyValue;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultStringPropertyValueEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPropertyValueEntityMapper
    implements EntityMapper<Long, IPropertyValue<Long>, DefaultPropertyValueEntity> {

  private final TestStringPropertyValueEntityMapper testStringPropertyValueEntityMapper;

  @Override
  public IPropertyValue<Long> toDomain(DefaultPropertyValueEntity entity) {
    return switch (entity.getType()) {
      case STRING -> testStringPropertyValueEntityMapper.toDomain(
          (DefaultStringPropertyValueEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public DefaultPropertyValueEntity toEntity(IPropertyValue<Long> type) {
    return switch (type.getType()) {
      case STRING -> testStringPropertyValueEntityMapper.toEntity(
          (DefaultStringPropertyValue) type);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public DefaultPropertyValueEntity toEntity(
      IPropertyValue<Long> type, DefaultPropertyValueEntity entity) {
    return switch (type.getType()) {
      case STRING -> testStringPropertyValueEntityMapper.toEntity(
          (DefaultStringPropertyValue) type, (DefaultStringPropertyValueEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }
}
