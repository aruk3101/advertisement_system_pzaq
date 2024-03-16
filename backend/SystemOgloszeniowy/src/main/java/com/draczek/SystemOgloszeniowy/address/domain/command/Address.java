package com.draczek.SystemOgloszeniowy.address.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.exception.AddressOptimisticLockException;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 * addresses table entity.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uuid", callSuper = false)
@Table(name = "addresses")
public class Address extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;

  @NotNull
  @Column(unique = true, updatable = false)
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID uuid;

  private String city;

  private String postalName;

  private String postalCode;

  private String street;

  private String streetNumber;

  private String apartmentNumber;

  private String country;

  /**
   * Version setter.
   */
  @Override
  public void setVersion(Integer version) {
    if (!Objects.equals(version, this.version)) {
      throw new AddressOptimisticLockException();
    }
    this.version = version;
  }

}
