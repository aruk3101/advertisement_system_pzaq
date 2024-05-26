package com.draczek.SystemOgloszeniowy.advertisement.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Value;

/**
 * CreateAdvertisementDto.
 */
@Value
public class CreateAdvertisementDto {

  UUID companyUuid;

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
}
