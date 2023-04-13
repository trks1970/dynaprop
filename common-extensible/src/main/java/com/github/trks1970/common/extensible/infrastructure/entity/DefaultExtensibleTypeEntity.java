package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "extensible_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Slf4j
public class DefaultExtensibleTypeEntity
    implements IExtensibleTypeEntity<Long, DefaultPropertyTypeEntity> {

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
  private String name;

  @Column(name = "description")
  @Nullable
  private String description;

  @OneToMany(mappedBy = "extensibleType", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<DefaultPropertyTypeEntity> propertyTypes = new HashSet<>();

  public DefaultPropertyTypeEntity addPropertyType(DefaultPropertyTypeEntity propertyType) {
    propertyType.setExtensibleType(this);
    log.debug("add {}", propertyTypes.add(propertyType));
    return propertyType;
  }

  public DefaultPropertyTypeEntity removePropertyType(DefaultPropertyTypeEntity propertyType) {
    log.debug("remove {} {}", propertyType, propertyTypes.remove(propertyType));
    propertyType.setExtensibleType(null);
    return propertyType;
  }
}
