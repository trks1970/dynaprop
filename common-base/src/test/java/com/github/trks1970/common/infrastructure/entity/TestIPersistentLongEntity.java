package com.github.trks1970.common.infrastructure.entity;

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
import org.springframework.lang.Nullable;

@Entity
@Table(name = "test_long")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TestIPersistentLongEntity implements IPersistentEntity<Long> {

  @Id
  @SequenceGenerator(
      name = "seq_test",
      sequenceName = "seq_test",
      initialValue = 1000,
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_test")
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Version
  @Column(name = "revision")
  @Nullable
  private Long revision;

  @Column(name = "bool_value")
  private Boolean value;
}
