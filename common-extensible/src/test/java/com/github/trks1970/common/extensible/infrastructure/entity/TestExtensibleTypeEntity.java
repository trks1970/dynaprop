package com.github.trks1970.common.extensible.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "extensible_type")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TestExtensibleTypeEntity implements ExtensibleTypeEntity<Long> {
  @Id
  @SequenceGenerator(
      name = "seq_extensible_type",
      sequenceName = "seq_extensible_type",
      initialValue = 1000,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_extensible_type")
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Version
  @Column(name = "revision")
  @Nullable
  private Long revision;

  @Column(name = "name", unique = true, nullable = false)
  @EqualsAndHashCode.Include
  @NonNull
  private String name;

  @Column(name = "description")
  @Nullable
  private String description;
}
