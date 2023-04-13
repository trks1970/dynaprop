package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.DefaultPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaDefaultPropertyTypeEntityEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification.DefaultPropertyTypeEntitySpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaNamedEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPropertyTypeRepositoryImpl
    extends PropertyTypeRepositoryBase<
        Long, IPropertyType<Long>, DefaultExtensibleTypeEntity, DefaultPropertyTypeEntity> {

  private final JpaDefaultPropertyTypeEntityEntityRepository jpaDefaultPropertyTypeEntityRepository;
  private final DefaultPropertyTypeEntityMapper defaultPropertyTypeEntityMapper;

  @Override
  protected EntityMapper<Long, IPropertyType<Long>, DefaultPropertyTypeEntity> mapper() {
    return defaultPropertyTypeEntityMapper;
  }

  @Override
  protected Specification<DefaultPropertyTypeEntity> name(String name) {
    return DefaultPropertyTypeEntitySpecification.name(name);
  }

  @Override
  protected JpaNamedEntityRepository<Long, DefaultPropertyTypeEntity, Long> repository() {
    return jpaDefaultPropertyTypeEntityRepository;
  }

  @Override
  protected Specification<DefaultPropertyTypeEntity> extensibleType(Long extensibleTypeId) {
    return DefaultPropertyTypeEntitySpecification.extensibleTypeId(extensibleTypeId);
  }
}
