package com.github.trks1970.common.extensible.infrastructure.repository.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyType;
import com.github.trks1970.common.extensible.domain.repository.propertytype.PropertyTypeRepository;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.ExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.PropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.PropertyValueEntity;
import com.github.trks1970.common.infrastructure.repository.NamedEntityRepositoryBase;
import com.github.trks1970.common.infrastructure.repository.jpa.JpaBaseRepository;
import java.io.Serializable;
import org.springframework.data.jpa.domain.Specification;

public abstract class PropertyTypeRepositoryBase<
        ID extends Serializable,
        PT extends PropertyType<ID>,
        ETE extends ExtensibleTypeEntity<ID>,
        EE extends ExtensibleEntity<ID, ETE>,
        PE extends PropertyTypeEntity<ID, ETE>,
        VE extends PropertyValueEntity<ID, ETE, EE, PE>>
    extends NamedEntityRepositoryBase<ID, PT, PE> implements PropertyTypeRepository<ID, PT> {

  protected abstract JpaBaseRepository<ETE, ID, Long> extensibleTypeEntityRepository();

  protected abstract JpaBaseRepository<VE, ID, Long> propertyValueEntityRepository();

  protected abstract Specification<VE> propertyType(ID propertyTypeId);

  @Override
  @SuppressWarnings("unchecked")
  public void addToType(ID extensibleTypeId, PT propertyType) {
    repository()
        .save(
            (PE)
                mapper()
                    .toEntity(propertyType)
                    .extensibleType(
                        extensibleTypeEntityRepository()
                            .findById(extensibleTypeId)
                            .orElseThrow(() -> notFoundException(extensibleTypeId, null, null))));
  }

  @Override
  public void deleteById(ID id) {
    propertyValueEntityRepository().delete(propertyType(id));
    repository().deleteById(id);
  }
}
