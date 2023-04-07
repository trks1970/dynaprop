package com.github.trks1970.dynaprop.infrastructure.entity.audit;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "revision")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@org.hibernate.envers.RevisionEntity(RevisionListener.class)
public class RevisionEntity {
  @Id
  @SequenceGenerator(
    name = "seq_revision",
    sequenceName = "seq_revision",
    initialValue = 1000,
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "seq_revision"
  )
  @Column(name = "id", nullable = false, updatable = false)
  @RevisionNumber
  private Long id;

  @Version
  @Column(name = "version")
  private Integer version;

  @RevisionTimestamp
  @EqualsAndHashCode.Include
  @Column(name = "timestamp", nullable = false)
  private long timestamp;

  @EqualsAndHashCode.Include
  @Column(name = "user_name", nullable = false)
  private String userName;
}
