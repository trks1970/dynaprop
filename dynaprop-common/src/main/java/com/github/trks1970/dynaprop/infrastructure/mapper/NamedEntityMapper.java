package com.github.trks1970.dynaprop.infrastructure.mapper;

import com.github.trks1970.dynaprop.domain.model.Named;
import com.github.trks1970.dynaprop.infrastructure.entity.NamedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = {TypeFactory.class, EntityFactory.class, PersistentEntityMapper.class})
public interface NamedEntityMapper extends EntityMapper<Named, NamedEntity> {
  Named toDomain(NamedEntity entity);
  NamedEntity toEntity(Named domain);
  NamedEntity toEntity(Named domain, @MappingTarget NamedEntity entity);
}
