package com.draczek.SystemOgloszeniowy.accountEducation.domain.dto;

import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAccountEducationDto dto.
 */
@Value
public class UpdateAccountEducationDto {
  String schoolName;

  String schoolLocation;

  UUID educationLevelUuid;

  String specialization;

  Date periodStart;

  Date periodEnd;

  @NotNull
  Integer version;
}