package com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertyvalue.DefaultPropertyValueEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.JpaDefaultPropertyValueEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertyvalue.jpa.specification.DefaultPropertyValueEntitySpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPropertyValueRepositoryImpl
    extends PropertyValueRepositoryBase<
        Long,
        DefaultExtensibleTypeEntity,
        DefaultExtensibleEntity,
        IPropertyValue<Long>,
        DefaultPropertyTypeEntity,
        DefaultPropertyValueEntity> {

  private final JpaDefaultPropertyValueEntityRepository jpaDefaultPropertyValueEntityRepository;
  private final JpaDefaultExtensibleEntityRepository jpaDefaultExtensibleEntityRepository;
  private final DefaultPropertyValueEntityMapper defaultPropertyValueEntityMapper;

  @Override
  protected JpaBaseRepository<DefaultPropertyValueEntity, Long, Long> repository() {
    return jpaDefaultPropertyValueEntityRepository;
  }

  @Override
  protected JpaBaseRepository<DefaultExtensibleEntity, Long, Long> extensibleEntityRepository() {
    return jpaDefaultExtensibleEntityRepository;
  }

  @Override
  protected EntityMapper<Long, IPropertyValue<Long>, DefaultPropertyValueEntity> mapper() {
    return defaultPropertyValueEntityMapper;
  }

  @Override
  protected Specification<DefaultPropertyValueEntity> name(String name) {
    return DefaultPropertyValueEntitySpecification.name(name);
  }
}
