package com.github.trks1970.common.infrastructure.entity.extensbile;

import com.github.trks1970.common.infrastructure.entity.NamedEntity;
import com.github.trks1970.common.infrastructure.entity.extensbile.id.EmbeddedPropertyTypeOfExtensibleTypeId;
import com.github.trks1970.common.infrastructure.entity.extensbile.id.PropertyTypeOfExtensibleTypeEntity;
import com.github.trks1970.common.infrastructure.entity.extensbile.propertytype.PropertyTypeEntity;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

public interface ExtensibleTypeEntity<ID extends Serializable, P extends PropertyTypeEntity<ID>>
    extends NamedEntity<ID> {

  PropertyTypeOfExtensibleTypeEntity<ID, P, ExtensibleTypeEntity<ID, P>> buildTypeProperty(
      EmbeddedPropertyTypeOfExtensibleTypeId<ID> id,
      ExtensibleTypeEntity<ID, P> extensibleType,
      PropertyTypeEntity<ID> property);

  Set<PropertyTypeOfExtensibleTypeEntity<ID, P, ExtensibleTypeEntity<ID, P>>> getPropertyTypes();

  default ExtensibleTypeEntity<ID, P> addPropertyType(PropertyTypeEntity<ID> propertyType) {
    PropertyTypeOfExtensibleTypeEntity<ID, P, ExtensibleTypeEntity<ID, P>> typeProperty =
        buildTypeProperty(
            new EmbeddedPropertyTypeOfExtensibleTypeId<>(this.getId(), propertyType.getId()),
            this,
            propertyType);
    getPropertyTypes().add(typeProperty);
    return this;
  }

  default ExtensibleTypeEntity<ID, P> removePropertyType(PropertyTypeEntity<ID> propertyType) {
    for (Iterator<PropertyTypeOfExtensibleTypeEntity<ID, P, ExtensibleTypeEntity<ID, P>>> iterator =
            getPropertyTypes().iterator();
        iterator.hasNext(); ) {
      PropertyTypeOfExtensibleTypeEntity<ID, P, ExtensibleTypeEntity<ID, P>> typeProperty =
          iterator.next();
      if (typeProperty.getExtensibleType().equals(this)
          && typeProperty.getPropertyType().equals(propertyType)) {
        iterator.remove();
        typeProperty.setPropertyType(null);
        typeProperty.setExtensibleType(null);
      }
    }
    return this;
  }
}
