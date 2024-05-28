package com.draczek.SystemOgloszeniowy.advertisement.domain.dto;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.AdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.AdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.AdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.company.domain.dto.CompanyDto;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.ContractTypeDto;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.JobTypeDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.WorkingTimeTypeDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AdvertisementDto.
 */
@Value
public class AdvertisementDto {

  UUID uuid;

  CompanyDto company;

  AdvertisementCategoryDto advertisementCategory;

  String position;

  PositionLevelDto positionLevel;

  ContractTypeDto contractType;

  WorkingTimeTypeDto workingTimeType;

  JobTypeDto jobType;

  Long salaryFrom;

  Long salaryTo;

  String workingDays;

  String workingHours;

  LocalDateTime expirationDate;

  List<AdvertisementResponsibilityDto> advertisementResponsibilities;

  List<AdvertisementRequirementDto> advertisementRequirements;

  @NotNull
  Integer version;
}
