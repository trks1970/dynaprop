package com.github.trks1970.dynaprop.infrastructure.entity.dynaprop;

import com.github.trks1970.dynaprop.infrastructure.entity.NamedEntity;
import com.github.trks1970.dynaprop.infrastructure.entity.dynaprop.id.EmbeddedPropertyTypeOfExtensibleTypeId;

import java.util.Iterator;
import java.util.Set;

public interface ExtensibleTypeEntity<P extends PropertyTypeEntity>
  extends NamedEntity {


  PropertyTypeOfExtensibleTypeEntity<ExtensibleTypeEntity<P>, P> buildTypeProperty(
    EmbeddedPropertyTypeOfExtensibleTypeId id,
    ExtensibleTypeEntity<P> extensibleType,
    PropertyTypeEntity property);

  Set<PropertyTypeOfExtensibleTypeEntity<ExtensibleTypeEntity<P>, P>> getPropertyTypes();

  default ExtensibleTypeEntity<P> addPropertyType(PropertyTypeEntity propertyType) {
    PropertyTypeOfExtensibleTypeEntity<ExtensibleTypeEntity<P>, P> typeProperty = buildTypeProperty(
      EmbeddedPropertyTypeOfExtensibleTypeId.builder()
        .extensibleTypeId(this.getId())
        .propertyTypeId(propertyType.getId())
        .build(),
      this,
      propertyType
    );
    getPropertyTypes().add(typeProperty);
    propertyType.getExtensibleTypes()
      .add(typeProperty);
    return this;
  }

  default ExtensibleTypeEntity<P> removePropertyType(PropertyTypeEntity propertyType) {
    for (Iterator<PropertyTypeOfExtensibleTypeEntity<ExtensibleTypeEntity<P>, P>> iterator = getPropertyTypes().iterator(); iterator.hasNext(); ) {
      PropertyTypeOfExtensibleTypeEntity<ExtensibleTypeEntity<P>, P> typeProperty = iterator.next();
      if (typeProperty.getExtensibleType().equals(this) && typeProperty.getPropertyType().equals(propertyType)) {
        iterator.remove();
        typeProperty.getPropertyType()
          .getExtensibleTypes()
          .remove(typeProperty);
        typeProperty.setPropertyType(null);
        typeProperty.setExtensibleType(null);
      }
    }
    return this;
  }
}
