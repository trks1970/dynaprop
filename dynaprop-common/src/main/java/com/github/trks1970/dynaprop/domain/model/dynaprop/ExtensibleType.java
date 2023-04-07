package com.github.trks1970.dynaprop.domain.model.dynaprop;

import com.github.trks1970.dynaprop.domain.model.Named;

import java.util.Set;

public interface ExtensibleType extends Named {
  Set<Long> getPropertyTypeIds();
}
