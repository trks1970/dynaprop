package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.IdProjection;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.repository.propertytype.jpa.JpaPropertyTypeRepository;
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
        PTE extends IPropertyTypeEntity<ID, ETE>>
    extends NamedEntityRepositoryBase<ID, ET, ETE> implements ExtensibleTypeRepository<ID, ET> {

  protected abstract JpaPropertyTypeRepository<ID, ETE, PTE> propertyTypeRepository();

  @Override
  public void deleteById(ID extensibleTypeId) {
    Set<IdProjection<ID>> propertyTypeIds =
        propertyTypeRepository().findIdByExtensibleTypeId(extensibleTypeId);
    propertyTypeRepository()
        .deleteAllById(
            propertyTypeIds.stream().map(IdProjection::getId).collect(Collectors.toSet()));
    repository().deleteById(extensibleTypeId);
  }
}
