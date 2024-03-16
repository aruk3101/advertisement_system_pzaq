package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto;

import java.util.UUID;
import lombok.Value;

/**
 * CreateAccountExperienceDutyDto dto.
 */
@Value
public class CreateAccountExperienceDutyDto {
  UUID accountExperienceUuid;

  String duty;
}

