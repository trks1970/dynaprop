package com.github.trks1970.common.infrastructure.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "test_uuid")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@SuppressFBWarnings(
    value = "NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR",
    justification =
        "Overriding the check on the env variable because Spring will automatically initialize "
            + "the variable after the constructor is called and before any public methods are called.")
public class TestNamedUuidEntity implements NamedEntity<UUID> {

  @Id
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @GeneratedValue(generator = "uuid2")
  @Column(name = "id", columnDefinition = "uuid")
  @Nullable
  private UUID id;

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
