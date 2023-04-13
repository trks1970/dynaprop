package com.github.trks1970.common.extensible.infrastructure.entity;

import com.github.trks1970.common.extensible.infrastructure.entity.propertytype.DefaultPropertyTypeEntity;
import com.github.trks1970.common.extensible.infrastructure.entity.propertyvalue.DefaultPropertyValueEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "extensible")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DefaultExtensibleEntity
    implements IExtensibleEntity<Long, DefaultPropertyTypeEntity, DefaultExtensibleTypeEntity> {
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "extensible_type_id")
  private DefaultExtensibleTypeEntity extensibleType;

  @OneToMany(mappedBy = "extensible", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<DefaultPropertyValueEntity> propertyValues = new HashSet<>();

  public void addPropertyValue(DefaultPropertyValueEntity propertyValue) {
    propertyValue.setExtensible(this);
    propertyValues.add(propertyValue);
  }

  public void removePropertyValue(DefaultPropertyValueEntity propertyValue) {
    propertyValues.remove(propertyValue);
    propertyValue.setExtensible(null);
  }
}
