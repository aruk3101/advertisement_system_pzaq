package com.draczek.SystemOgloszeniowy.accountExperience.domain.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAccountExperienceDto dto.
 */
@Value
public class UpdateAccountExperienceDto {
  String position;

  String companyName;

  String location;

  Date periodStart;

  Date periodEnd;

  @NotNull
  Integer version;
}
