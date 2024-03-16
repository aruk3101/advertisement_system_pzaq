package com.draczek.SystemOgloszeniowy.accountLanguage.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AccountLanguageNotFoundException entity not found exception.
 */
public final class AccountLanguageNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "account_language_not_found";

  public AccountLanguageNotFoundException(UUID uuid) {
    super(String.format("Could not find Account Language with UUID: %s", uuid), DEFAULT_CODE);
  }
}
