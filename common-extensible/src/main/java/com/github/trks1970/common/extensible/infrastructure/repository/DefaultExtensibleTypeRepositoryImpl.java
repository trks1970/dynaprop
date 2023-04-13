package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.DefaultExtensibleTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.DefaultPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.specification.DefaultExtensibleTypeSpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaNamedEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DefaultExtensibleTypeRepositoryImpl
    extends ExtensibleTypeRepositoryBase<
        Long,
        DefaultExtensibleType,
        IPropertyType<Long>,
        DefaultPropertyTypeEntity,
        DefaultExtensibleTypeEntity> {

  private final JpaDefaultExtensibleTypeEntityRepository jpaExtensibleTypeEntityRepository;
  private final DefaultExtensibleTypeEntityMapper extensibleTypeEntityMapper;
  private final DefaultPropertyTypeEntityMapper propertyTypeEntityMapper;

  @Override
  protected JpaNamedEntityRepository<Long, DefaultExtensibleTypeEntity, Long> repository() {
    return jpaExtensibleTypeEntityRepository;
  }

  @Override
  protected EntityMapper<Long, DefaultExtensibleType, DefaultExtensibleTypeEntity> mapper() {
    return extensibleTypeEntityMapper;
  }

  @Override
  protected Specification<DefaultExtensibleTypeEntity> name(String name) {
    return DefaultExtensibleTypeSpecification.name(name);
  }

  @Override
  protected EntityMapper<Long, IPropertyType<Long>, DefaultPropertyTypeEntity>
      propertyTypeMapper() {
    return propertyTypeEntityMapper;
  }
}
