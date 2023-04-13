package com.github.trks1970.common.extensible.domain.model.propertytype;

import com.github.trks1970.common.extensible.domain.model.Types;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
public class DefaultBooleanPropertyType implements IPropertyType<Long> {
  Long id;
  @NonNull @lombok.NonNull @EqualsAndHashCode.Include String name;
  String description;

  @Override
  public Types getType() {
    return Types.BOOLEAN;
  }
}
