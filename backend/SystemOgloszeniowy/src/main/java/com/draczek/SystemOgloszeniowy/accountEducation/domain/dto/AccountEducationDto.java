package com.draczek.SystemOgloszeniowy.accountEducation.domain.dto;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.EducationLevelDto;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AccountEducationDto dto.
 */
@Value
public class AccountEducationDto {
  UUID uuid;

  String schoolName;

  String schoolLocation;

  EducationLevelDto educationLevel;

  String specialization;

  Date periodStart;

  Date periodEnd;

  @NotNull
  Integer version;
}
