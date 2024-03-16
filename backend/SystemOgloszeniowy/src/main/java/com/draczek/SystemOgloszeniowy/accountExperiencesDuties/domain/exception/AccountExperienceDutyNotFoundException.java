package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AccountExperienceDutyNotFoundException entity not found exception.
 */
public final class AccountExperienceDutyNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "account_experience_duty_not_found";

  public AccountExperienceDutyNotFoundException(UUID uuid) {
    super(String.format("Could not find Account Experience Duty with UUID: %s", uuid),
        DEFAULT_CODE);
  }
}
