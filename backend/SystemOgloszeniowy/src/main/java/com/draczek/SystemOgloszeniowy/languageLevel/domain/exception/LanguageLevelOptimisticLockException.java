package com.draczek.SystemOgloszeniowy.languageLevel.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of LanguageLevel's invalid version exception.
 */
public class LanguageLevelOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "language_level_optimistic_lock";

  public LanguageLevelOptimisticLockException() {
    super("Version of LanguageLevel is invalid", DEFAULT_CODE);
  }
}
