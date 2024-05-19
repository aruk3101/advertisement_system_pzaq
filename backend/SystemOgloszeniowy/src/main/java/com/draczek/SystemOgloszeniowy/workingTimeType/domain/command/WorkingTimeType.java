package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import com.draczek.SystemOgloszeniowy.common.entity.AuditableEntity;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.draczek.SystemOgloszeniowy.workingTimeType.domain.exception.WorkingTimeTypeOptimisticLockException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 * Advertisement entity.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uuid", callSuper = false)
@Table(name = "working_time_types")
public final class WorkingTimeType extends AuditableEntity {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true, updatable = false)
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID uuid;

  private String name;

  /**
   * Version setter.
   */
  @Override
  public void setVersion(Integer version) {
    if (!Objects.equals(version, this.version)) {
      throw new WorkingTimeTypeOptimisticLockException();
    }
    this.version = version;
  }
}
