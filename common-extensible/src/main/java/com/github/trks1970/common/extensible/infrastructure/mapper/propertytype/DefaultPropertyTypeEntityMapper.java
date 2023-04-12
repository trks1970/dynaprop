package com.github.trks1970.common.extensible.infrastructure.mapper.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.DefaultStringPropertyType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultStringPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPropertyTypeEntityMapper
    implements EntityMapper<Long, IPropertyType<Long>, DefaultPropertyTypeEntity> {

  private final DefaultStringPropertyTypeEntityMapper defaultStringPropertyTypeEntityMapper;

  @Override
  public IPropertyType<Long> toDomain(DefaultPropertyTypeEntity entity) {
    return switch (entity.getType()) {
      case STRING -> defaultStringPropertyTypeEntityMapper.toDomain(
          (DefaultStringPropertyTypeEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public DefaultPropertyTypeEntity toEntity(IPropertyType<Long> type) {
    return switch (type.getType()) {
      case STRING -> defaultStringPropertyTypeEntityMapper.toEntity(
          (DefaultStringPropertyType) type);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }

  @Override
  public DefaultPropertyTypeEntity toEntity(
      IPropertyType<Long> type, DefaultPropertyTypeEntity entity) {
    return switch (type.getType()) {
      case STRING -> defaultStringPropertyTypeEntityMapper.toEntity(
          (DefaultStringPropertyType) type, (DefaultStringPropertyTypeEntity) entity);
      case BOOLEAN -> throw new IllegalStateException();
    };
  }
}
