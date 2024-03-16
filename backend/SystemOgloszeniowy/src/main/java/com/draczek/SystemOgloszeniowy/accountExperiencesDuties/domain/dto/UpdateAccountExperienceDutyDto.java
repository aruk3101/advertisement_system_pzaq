package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAccountExperienceDutyDto dto.
 */
@Value
public class UpdateAccountExperienceDutyDto {
  String duty;

  @NotNull
  Integer version;
}
