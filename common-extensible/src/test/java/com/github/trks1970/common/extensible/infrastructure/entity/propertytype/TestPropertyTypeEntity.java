package com.github.trks1970.common.extensible.infrastructure.entity.propertytype;

import com.github.trks1970.common.extensible.infrastructure.entity.TestExtensibleTypeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "property_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class TestPropertyTypeEntity
    implements PropertyTypeEntity<Long, TestExtensibleTypeEntity> {
  @Id
  @SequenceGenerator(
      name = "seq_property_type",
      sequenceName = "seq_property_type",
      initialValue = 1000,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_property_type")
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Version
  @Column(name = "revision")
  @Nullable
  private Long revision;

  @Column(name = "name", unique = true, nullable = false)
  @EqualsAndHashCode.Include
  private String name;

  @Column(name = "description")
  @Nullable
  private String description;

  @ManyToOne
  @JoinColumn(name = "extensible_type_id")
  private TestExtensibleTypeEntity extensibleType;
}
