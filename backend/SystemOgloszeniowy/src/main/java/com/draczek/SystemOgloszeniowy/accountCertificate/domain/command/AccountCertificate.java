package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.exception.AccountCertificateOptimisticLockException;
import com.draczek.SystemOgloszeniowy.common.entity.AuditableEntity;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Date;
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
 * AccountCertificate entity.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uuid", callSuper = false)
@Table(name = "accounts_certificates")
public class AccountCertificate extends AuditableEntity {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true, updatable = false)
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID uuid;

  @ManyToOne
  @JoinColumn(name = "accounts_id", nullable = false)
  private Account account;

  @NotNull
  private String name;

  @NotNull
  private String host;

  @NotNull
  private Date date;

  /**
   * Version setter.
   */
  @Override
  public void setVersion(Integer version) {
    if (!Objects.equals(version, this.version)) {
      throw new AccountCertificateOptimisticLockException();
    }
    this.version = version;
  }
}
