package com.github.trks1970.dynaprop.infrastructure.entity.dynaprop.id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class EmbeddedPropertyTypeOfExtensibleTypeId implements Serializable {
  @Column(name = "property_type_id", nullable = false, updatable = false)
  private Long propertyTypeId;
  @Column(name = "extensible_type_id", nullable = false, updatable = false)
  private Long extensibleTypeId;
}
