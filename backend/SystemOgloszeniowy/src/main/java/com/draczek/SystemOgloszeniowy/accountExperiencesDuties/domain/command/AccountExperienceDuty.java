package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.command.AccountExperience;
import com.draczek.SystemOgloszeniowy.common.entity.AuditableEntity;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 * AccountExperienceDuty entity.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uuid", callSuper = false)
@Table(name = "accounts_experiences_duties")
public class AccountExperienceDuty extends AuditableEntity {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Column(unique = true, updatable = false)
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID uuid;

  @ManyToOne
  @JoinColumn(name = "accounts_experience_id", nullable = false)
  private AccountExperience accountExperience;

  @NotNull
  private String duty;

  /**
   * Version setter.
   */
  @Override
  public void setVersion(Integer version) {
    if (!Objects.equals(version, this.version)) {
      //throw new UserOptimisticLockException();
    }
    this.version = version;
  }
}
