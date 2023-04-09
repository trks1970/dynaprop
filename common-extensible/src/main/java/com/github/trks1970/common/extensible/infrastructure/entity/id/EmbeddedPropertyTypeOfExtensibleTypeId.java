package com.github.trks1970.common.extensible.infrastructure.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedPropertyTypeOfExtensibleTypeId<ID extends Serializable>
    implements Serializable {
  @Column(name = "property_type_id", nullable = false, updatable = false)
  private ID propertyTypeId;

  @Column(name = "extensible_type_id", nullable = false, updatable = false)
  private ID extensibleTypeId;
}
