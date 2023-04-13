package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.DefaultExtensibleTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaExtensibleEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.specification.DefaultExtensibleTypeSpecification;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaDefaultPropertyTypeEntityRepository;
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
        DefaultExtensibleTypeEntity,
        DefaultExtensibleEntity,
        DefaultPropertyTypeEntity> {

  private final JpaDefaultExtensibleTypeEntityRepository jpaExtensibleTypeEntityRepository;
  private final JpaDefaultPropertyTypeEntityRepository jpaPropertyTypeEntityRepository;
  private final JpaDefaultExtensibleEntityRepository jpaExtensibleEntityRepository;
  private final DefaultExtensibleTypeEntityMapper extensibleTypeEntityMapper;

  @Override
  protected EntityMapper<Long, DefaultExtensibleType, DefaultExtensibleTypeEntity> mapper() {
    return extensibleTypeEntityMapper;
  }

  @Override
  protected Specification<DefaultExtensibleTypeEntity> name(String name) {
    return DefaultExtensibleTypeSpecification.name(name);
  }

  @Override
  protected JpaNamedEntityRepository<Long, DefaultExtensibleTypeEntity, Long> repository() {
    return jpaExtensibleTypeEntityRepository;
  }

  @Override
  protected JpaDefaultPropertyTypeEntityRepository propertyTypeRepository() {
    return jpaPropertyTypeEntityRepository;
  }

  @Override
  protected JpaExtensibleEntityRepository<
          Long, DefaultExtensibleTypeEntity, DefaultExtensibleEntity>
      extensibleRepository() {
    return jpaExtensibleEntityRepository;
  }
}
