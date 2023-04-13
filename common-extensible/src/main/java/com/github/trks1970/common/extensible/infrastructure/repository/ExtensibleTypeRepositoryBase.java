package com.github.trks1970.common.extensible.infrastructure.repository;

import com.github.trks1970.common.extensible.domain.model.IExtensibleType;
import com.github.trks1970.common.extensible.domain.model.propertytype.IPropertyType;
import com.github.trks1970.common.extensible.domain.repository.ExtensibleTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.IExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.IPropertyTypeEntity;
import com.github.trks1970.common.infrastructure.mapper.EntityMapper;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import java.io.Serializable;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class ExtensibleTypeRepositoryBase<
        ID extends Serializable,
        ET extends IExtensibleType<ID>,
        PT extends IPropertyType<ID>,
        PTE extends IPropertyTypeEntity<ID>,
        ETE extends IExtensibleTypeEntity<ID, PTE>>
    extends NamedEntityRepositoryBase<ID, ET, ETE> implements ExtensibleTypeRepository<ID, PT, ET> {

  protected abstract EntityMapper<ID, IPropertyType<ID>, PTE> propertyTypeMapper();

  @Override
  public PT addPropertyType(ID extensibleTypeId, PT propertyType) {
    return performAction(
        extensibleTypeId,
        (pt, ete) -> ete.addPropertyType(propertyTypeMapper().toEntity(pt)),
        propertyType);
  }

  @Override
  public PT removePropertyType(ID extensibleTypeId, PT propertyType) {
    return performAction(
        extensibleTypeId,
        (pt, ete) -> ete.removePropertyType(propertyTypeMapper().toEntity(pt)),
        propertyType);
  }

  @SuppressWarnings("unchecked")
  private PT performAction(
      ID extensibleTypeId, BiFunction<PT, ETE, PTE> function, PT propertyType) {
    ETE ete = findEntityById(extensibleTypeId);
    PTE pte = function.apply(propertyType, ete);
    repository().save(ete);
    return (PT) propertyTypeMapper().toDomain(pte);
  }
}
