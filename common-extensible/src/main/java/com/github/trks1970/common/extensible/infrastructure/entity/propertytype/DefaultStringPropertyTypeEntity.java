package com.github.trks1970.common.extensible.infrastructure.entity.propertytype;

import com.github.trks1970.common.extensible.domain.model.Types;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class DefaultStringPropertyTypeEntity extends DefaultPropertyTypeEntity
    implements IPropertyTypeEntity<Long, DefaultExtensibleTypeEntity> {

  @Override
  public Types getType() {
    return Types.STRING;
  }
}
