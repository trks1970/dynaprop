package com.github.trks1970.common.extensible.infrastructure.entity.propertytype;

import com.github.trks1970.common.extensible.domain.model.propertytype.PropertyTypes;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class TestStringPropertyTypeEntity extends TestPropertyTypeEntity
    implements PropertyTypeEntity<Long, TestExtensibleTypeEntity> {

  @Override
  public PropertyTypes getType() {
    return PropertyTypes.STRING;
  }
}
