package com.draczek.SystemOgloszeniowy.accountExperience.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AccountExperience's invalid version exception.
 */
public class AccountExperienceOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "account_experience_optimistic_lock";

  public AccountExperienceOptimisticLockException() {
    super("Version of AccountExperience is invalid", DEFAULT_CODE);
  }
}
