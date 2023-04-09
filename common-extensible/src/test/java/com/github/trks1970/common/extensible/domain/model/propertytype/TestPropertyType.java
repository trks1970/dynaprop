package com.github.trks1970.common.extensible.domain.model.propertytype;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.hibernate.validator.internal.properties.Property;
import org.springframework.lang.NonNull;

public interface TestPropertyType extends PropertyType<Long> {
}
