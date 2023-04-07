package com.github.trks1970.dynaprop.domain.model.dynaprop;

import com.github.trks1970.dynaprop.domain.model.Named;
import com.github.trks1970.dynaprop.domain.model.dynaprop.propertytype.PropertyTypes;

import java.util.Set;

public interface PropertyType extends Named {
  Set<Long> getExtensibleTypeIds();
  PropertyTypes getPropertyType();
}
