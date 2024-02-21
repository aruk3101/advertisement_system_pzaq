package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.command.AccountCertificate;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.command.AccountEducation;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.command.AccountExperience;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.command.AccountLanguage;
import com.draczek.SystemOgloszeniowy.accountLink.domain.command.AccountLink;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.command.AccountSkill;
import com.draczek.SystemOgloszeniowy.address.domain.command.Address;
import com.draczek.SystemOgloszeniowy.common.entity.AuditableEntity;
import com.draczek.SystemOgloszeniowy.user.domain.exception.UserOptimisticLockException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
 * Account entity.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uuid", callSuper = false)
@Table(name = "accounts")
public class Account extends AuditableEntity {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true, updatable = false)
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID uuid;

  @NotNull
  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  private String firstName;

  private String lastName;

  private Date birthDate;

  private String phoneNumber;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private Address address;

  private String profilePictureSource;

  @OneToMany(mappedBy = "account")
  private List<AccountCertificate> accountCertificates;

  @OneToMany(mappedBy = "account")
  private List<AccountLink> accountLinks;

  @OneToMany(mappedBy = "account")
  private List<AccountSkill> accountSkills;

  @OneToMany(mappedBy = "account")
  private List<AccountEducation> accountEducations;

  @OneToMany(mappedBy = "account")
  private List<AccountExperience> accountExperiences;

  @OneToMany(mappedBy = "account")
  private List<AccountLanguage> accountLanguages;

  /**
   * Version setter.
   */
  @Override
  public void setVersion(Integer version) {
    if (!Objects.equals(version, this.version)) {
      throw new UserOptimisticLockException();
    }
    this.version = version;
  }
}
