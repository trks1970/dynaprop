package com.github.trks1970.dynaprop.infrastructure.mapper;

import com.github.trks1970.dynaprop.domain.model.Persistent;
import com.github.trks1970.dynaprop.infrastructure.entity.PersistentEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-07T09:46:27+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.0.2.jar, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class PersistentEntityMapperImpl implements PersistentEntityMapper {

    @Autowired
    private TypeFactory typeFactory;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Persistent toDomain(PersistentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Persistent persistent = typeFactory.createType( entity, Persistent.class );

        return persistent;
    }

    @Override
    public PersistentEntity toEntity(Persistent domain) {
        if ( domain == null ) {
            return null;
        }

        PersistentEntity persistentEntity = entityFactory.createEntity( domain, PersistentEntity.class );

        return persistentEntity;
    }

    @Override
    public PersistentEntity toEntity(Persistent domain, PersistentEntity entity) {
        if ( domain == null ) {
            return entity;
        }

        return entity;
    }
}
