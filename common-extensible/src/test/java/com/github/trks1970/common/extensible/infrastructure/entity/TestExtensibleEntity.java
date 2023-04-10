package com.github.trks1970.common.extensible.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "extensible")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TestExtensibleEntity implements ExtensibleEntity<Long, TestExtensibleTypeEntity> {
  @Id
  @SequenceGenerator(
      name = "seq_extensible",
      sequenceName = "seq_extensible",
      initialValue = 1000,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_extensible")
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Version
  @Column(name = "revision")
  @Nullable
  private Long revision;

  @ManyToOne
  @JoinColumn(name = "extensible_type_id")
  private TestExtensibleTypeEntity extensibleType;
}
