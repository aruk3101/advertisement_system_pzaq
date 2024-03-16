package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AccountExperienceDutyDto dto.
 */
@Value
public class AccountExperienceDutyDto {
  UUID uuid;

  String duty;

  @NotNull
  Integer version;
}
