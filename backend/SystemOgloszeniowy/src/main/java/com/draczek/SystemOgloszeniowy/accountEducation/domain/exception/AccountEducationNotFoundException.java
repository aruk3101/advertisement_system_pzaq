package com.draczek.SystemOgloszeniowy.accountEducation.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AccountEducationNotFoundException entity not found exception.
 */
public final class AccountEducationNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "account_education_not_found";

  public AccountEducationNotFoundException(UUID uuid) {
    super(String.format("Could not find Account Education with UUID: %s", uuid), DEFAULT_CODE);
  }
}

