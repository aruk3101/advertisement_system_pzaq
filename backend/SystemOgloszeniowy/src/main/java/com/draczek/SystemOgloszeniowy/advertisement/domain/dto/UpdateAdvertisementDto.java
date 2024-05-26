package com.draczek.SystemOgloszeniowy.advertisement.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAdvertisementDto.
 */
@Value
public class UpdateAdvertisementDto {

  String position;

  UUID positionLevelUuid;

  UUID contractTypeUuid;

  UUID workingTimeTypeUuid;

  UUID jobTypeUuid;

  Long salaryFrom;

  Long salaryTo;

  String workingDays;

  String workingHours;

  LocalDateTime expirationDate;

  @NotNull
  Integer version;
}
