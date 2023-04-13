package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.propertytype.DefaultPropertyTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaDefaultPropertyTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaPropertyTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.specification.DefaultPropertyTypeEntitySpecification;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPropertyTypeRepositoryImpl
    extends PropertyTypeRepositoryBase<Long, IPropertyType<Long>, DefaultPropertyTypeEntity> {

  private final JpaDefaultPropertyTypeEntityRepository jpaPropertyTypeRepository;
  private final DefaultPropertyTypeEntityMapper propertyTypeEntityMapper;

  @Override
  protected JpaPropertyTypeEntityRepository<Long, DefaultPropertyTypeEntity> repository() {
    return jpaPropertyTypeRepository;
  }

  @Override
  protected EntityMapper<Long, IPropertyType<Long>, DefaultPropertyTypeEntity> mapper() {
    return propertyTypeEntityMapper;
  }

  @Override
  protected Specification<DefaultPropertyTypeEntity> name(String name) {
    return DefaultPropertyTypeEntitySpecification.name(name);
  }
}
