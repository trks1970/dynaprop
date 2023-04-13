package com.github.trks1970.common.extensible.domain.model.propertyvalue;

import com.github.trks1970.common.extensible.domain.model.Types;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@Builder
public class DefaultStringPropertyValue implements IPropertyValue<Long> {
  Long id;
  @NonNull @lombok.NonNull @EqualsAndHashCode.Include String name;
  String description;
  @EqualsAndHashCode.Include Object valueObject;
  Long extensibleId;
  Long propertyTypeId;

  @Override
  public Types getType() {
    return Types.STRING;
  }
}
