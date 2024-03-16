package com.draczek.SystemOgloszeniowy.languageLevel.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * LanguageLevelNotFoundException entity not found exception.
 */
public final class LanguageLevelNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "language_level_not_found";

  public LanguageLevelNotFoundException(UUID uuid) {
    super(String.format("Could not find Language level with UUID: %s", uuid), DEFAULT_CODE);
  }
}
