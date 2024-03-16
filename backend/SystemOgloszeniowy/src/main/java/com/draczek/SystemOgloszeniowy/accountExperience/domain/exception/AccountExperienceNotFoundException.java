package com.draczek.SystemOgloszeniowy.accountExperience.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AccountExperienceNotFoundException entity not found exception.
 */
public final class AccountExperienceNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "account_experience_not_found";

  public AccountExperienceNotFoundException(UUID uuid) {
    super(String.format("Could not find Account Experience with UUID: %s", uuid), DEFAULT_CODE);
  }
}
