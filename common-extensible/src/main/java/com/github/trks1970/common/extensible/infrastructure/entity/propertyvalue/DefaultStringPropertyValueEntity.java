package com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.Types;
import com.github.trks1970.common.extensible.infrastructure.PropertyDiscriminator;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.DefaultExtensibleTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@DiscriminatorValue(PropertyDiscriminator.STRING)
public class DefaultStringPropertyValueEntity extends DefaultPropertyValueEntity
    implements IPropertyValueEntity<
        Long, DefaultExtensibleTypeEntity, DefaultExtensibleEntity, DefaultPropertyTypeEntity> {

  @Column(name = "string_value")
  private String valueObject;

  @Override
  public Object getValueObject() {
    return valueObject;
  }

  @Override
  public Types getType() {
    return Types.STRING;
  }
}
