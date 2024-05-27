package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.exception.AdvertisementOptimisticLockException;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command.AdvertisementCategory;
import com.draczek.SystemOgloszeniowy.common.entity.AuditableEntity;
import com.draczek.SystemOgloszeniowy.company.domain.command.Company;
import com.draczek.SystemOgloszeniowy.contractType.domain.command.ContractType;
import com.draczek.SystemOgloszeniowy.jobType.domain.command.JobType;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.command.PositionLevel;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.command.WorkingTimeType;
import java.time.LocalDateTime;
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
 * Advertisement entity.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uuid", callSuper = false)
@Table(name = "advertisements")
public final class Advertisement extends AuditableEntity {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true, updatable = false)
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID uuid;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private AdvertisementCategory advertisementCategory;

  private String position;

  @ManyToOne
  @JoinColumn(name = "position_level_id")
  private PositionLevel positionLevel;

  @ManyToOne
  @JoinColumn(name = "contract_type_id")
  private ContractType contractType;

  @ManyToOne
  @JoinColumn(name = "working_time_type_id")
  private WorkingTimeType workingTimeType;

  @ManyToOne
  @JoinColumn(name = "job_type_id")
  private JobType jobType;

  private Long salaryFrom;

  private Long salaryTo;

  private String workingDays;

  private String workingHours;

  private LocalDateTime expirationDate;

  /**
   * Version setter.
   */
  @Override
  public void setVersion(Integer version) {
    if (!Objects.equals(version, this.version)) {
      throw new AdvertisementOptimisticLockException();
    }
    this.version = version;
  }
}
