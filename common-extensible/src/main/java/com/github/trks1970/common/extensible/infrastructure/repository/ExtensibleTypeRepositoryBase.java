package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.jpa.JpaExtensibleEntityRepository;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaPropertyTypeEntityRepository;
import com.github.trks1970.common.infrastructure.entity.IPersistentEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class ExtensibleTypeRepositoryBase<
        ID extends Serializable,
        ET extends IExtensibleType<ID>,
        ETE extends IExtensibleTypeEntity<ID>,
        EE extends IExtensibleEntity<ID, ETE>,
        PTE extends IPropertyTypeEntity<ID, ETE>>
    extends NamedEntityRepositoryBase<ID, ET, ETE> implements ExtensibleTypeRepository<ID, ET> {

  protected abstract JpaPropertyTypeEntityRepository<ID, ETE, PTE> propertyTypeRepository();

  protected abstract JpaExtensibleEntityRepository<ID, ETE, EE> extensibleRepository();

  @Override
  @SuppressWarnings("unchecked")
  public void deleteById(ID extensibleTypeId) {
    log.trace("deleteById enter {}", extensibleTypeId);
    propertyTypeRepository()
        .deleteAllById(
            propertyTypeRepository().findByExtensibleTypeId(extensibleTypeId).stream()
                .map(IPersistentEntity::getId)
                .collect(Collectors.toSet()));
    extensibleRepository()
        .saveAll(
            (Set<EE>)
                extensibleRepository().findByExtensibleTypeId(extensibleTypeId).stream()
                    .map(entity -> entity.setExtensibleType(null))
                    .collect(Collectors.toSet()));
    repository().deleteById(extensibleTypeId);
    log.trace("deleteById exit {}", extensibleTypeId);
  }
}
