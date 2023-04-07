package com.github.trks1970.dynaprop.infrastructure.mapper;


import com.github.trks1970.dynaprop.domain.model.Persistent;
import com.github.trks1970.dynaprop.infrastructure.entity.PersistentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = {TypeFactory.class, EntityFactory.class})
public interface PersistentEntityMapper extends EntityMapper<Persistent, PersistentEntity> {
  Persistent toDomain(PersistentEntity entity);
  PersistentEntity toEntity(Persistent domain);
  PersistentEntity toEntity(Persistent domain, @MappingTarget PersistentEntity entity);
}
