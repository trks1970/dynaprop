package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensibleType;
import com.github.trks1970.common.extensible.domain.repository.TestExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IdProjection;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.DefaultExtensibleTypeEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleTypeEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.specification.DefaultExtensibleTypeSpecification;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaDefaultPropertyTypeEntityRepository;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestExtensibleTypeRepositoryImpl
    extends ExtensibleTypeRepositoryBase<
        Long, DefaultExtensibleType, DefaultExtensibleTypeEntity, DefaultPropertyTypeEntity>
    implements TestExtensibleTypeRepository {

  private final JpaDefaultExtensibleTypeEntityRepository jpaDefaultExtensibleTypeEntityRepository;
  private final JpaDefaultPropertyTypeEntityRepository jpaDefaultPropertyTypeEntityRepository;
  private final DefaultExtensibleTypeEntityMapper defaultExtensibleTypeEntityMapper;

  public void deleteById(Long extensibleTypeId) {
    log.trace("propertyTypeIds");
    Set<IdProjection<Long>> propertyTypeIds =
        jpaDefaultPropertyTypeEntityRepository.findIdByExtensibleTypeId(extensibleTypeId);
    log.trace("delete propertyTypes");
    jpaDefaultPropertyTypeEntityRepository.deleteAllById(
        propertyTypeIds.stream().map(IdProjection::getId).collect(Collectors.toSet()));
    log.trace("delete extensibleType");
    repository().deleteById(extensibleTypeId);
  }

  @Override
  protected JpaBaseRepository<DefaultExtensibleTypeEntity, Long, Long> repository() {
    return jpaDefaultExtensibleTypeEntityRepository;
  }

  @Override
  protected EntityMapper<Long, DefaultExtensibleType, DefaultExtensibleTypeEntity> mapper() {
    return defaultExtensibleTypeEntityMapper;
  }

  @Override
  protected Specification<DefaultExtensibleTypeEntity> name(String name) {
    return DefaultExtensibleTypeSpecification.name(name);
  }

  @Override
  protected JpaDefaultPropertyTypeEntityRepository propertyTypeRepository() {
    return jpaDefaultPropertyTypeEntityRepository;
  }
}
