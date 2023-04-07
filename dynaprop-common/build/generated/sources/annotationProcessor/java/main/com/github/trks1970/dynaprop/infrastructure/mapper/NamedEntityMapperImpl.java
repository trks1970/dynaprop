package com.github.trks1970.dynaprop.infrastructure.mapper;

import com.github.trks1970.dynaprop.domain.model.Named;
import com.github.trks1970.dynaprop.infrastructure.entity.NamedEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-07T09:46:27+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.0.2.jar, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class NamedEntityMapperImpl implements NamedEntityMapper {

    @Autowired
    private TypeFactory typeFactory;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Named toDomain(NamedEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Named named = typeFactory.createType( entity, Named.class );

        return named;
    }

    @Override
    public NamedEntity toEntity(Named domain) {
        if ( domain == null ) {
            return null;
        }

        NamedEntity namedEntity = entityFactory.createEntity( domain, NamedEntity.class );

        return namedEntity;
    }

    @Override
    public NamedEntity toEntity(Named domain, NamedEntity entity) {
        if ( domain == null ) {
            return entity;
        }

        return entity;
    }
}
