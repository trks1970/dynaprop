package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensible;
import com.github.trks1970.common.extensible.domain.model.propertyvalue.IPropertyValue;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.DefaultExtensibleEntityMapper;
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
public class DefaultExtensibleRepositoryImpl
    extends ExtensibleRepositoryBase<
        Long,
        IPropertyValue<Long>,
        DefaultExtensible,
        DefaultExtensibleTypeEntity,
        DefaultPropertyTypeEntity,
        DefaultExtensibleEntity,
        DefaultPropertyValueEntity> {

  private final JpaDefaultExtensibleEntityRepository jpaDefaultExtensibleEntityRepository;
  private final JpaDefaultPropertyValueEntityRepository jpaDefaultPropertyValueEntityRepository;
  private final DefaultExtensibleEntityMapper defaultExtensibleEntityMapper;
  private final DefaultPropertyValueEntityMapper defaultPropertyValueEntityMapper;

  @Override
  protected JpaBaseRepository<DefaultExtensibleEntity, Long, Long> repository() {
    return jpaDefaultExtensibleEntityRepository;
  }

  @Override
  protected EntityMapper<Long, DefaultExtensible, DefaultExtensibleEntity> mapper() {
    return defaultExtensibleEntityMapper;
  }

  @Override
  protected JpaBaseRepository<DefaultPropertyValueEntity, Long, Long>
      propertyValueEntityRepository() {
    return jpaDefaultPropertyValueEntityRepository;
  }

  @Override
  protected Specification<DefaultPropertyValueEntity> extensibleId(Long extensibleId) {
    return DefaultPropertyValueEntitySpecification.extensibleId(extensibleId);
  }

  @Override
  protected EntityMapper<Long, IPropertyValue<Long>, DefaultPropertyValueEntity>
      propertyValueEntityMapper() {
    return defaultPropertyValueEntityMapper;
  }
}
