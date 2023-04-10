package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.TestPropertyTypeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class TestStringPropertyValueEntity extends TestPropertyValueEntity
    implements StringPropertyValueEntity<
        Long, TestExtensibleTypeEntity, TestExtensibleEntity, TestPropertyTypeEntity> {

  @Column(name = "string_value")
  private String valueObject;

  @Override
  public Object getValueObject() {
    return valueObject;
  }
}
