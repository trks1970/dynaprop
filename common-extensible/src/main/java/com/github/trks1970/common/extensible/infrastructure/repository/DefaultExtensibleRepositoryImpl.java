package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.DefaultExtensible;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.mapper.DefaultExtensibleEntityMapper;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaDefaultExtensibleEntityRepository;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultExtensibleRepositoryImpl
    extends ExtensibleRepositoryBase<
        Long, DefaultExtensible, DefaultExtensibleTypeEntity, DefaultExtensibleEntity> {

  private final JpaDefaultExtensibleEntityRepository jpaDefaultExtensibleEntityRepository;
  private final DefaultExtensibleEntityMapper defaultExtensibleEntityMapper;

  @Override
  protected JpaBaseRepository<Long, DefaultExtensibleEntity, Long> repository() {
    return jpaDefaultExtensibleEntityRepository;
  }

  @Override
  protected EntityMapper<Long, DefaultExtensible, DefaultExtensibleEntity> mapper() {
    return defaultExtensibleEntityMapper;
  }
}
