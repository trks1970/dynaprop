package com.github.trks1970.dynaprop.domain.model.dynaprop;

import com.github.trks1970.dynaprop.domain.model.Persistent;

import java.util.Set;

public interface Extensible extends Persistent {
  Long getExtensibleTypeId();
  Set<? extends PropertyValue> getPropertyValues();
}
