package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AccountExperienceDuty's invalid version exception.
 */
public class AccountExperienceDutyOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "account_experience_duty_optimistic_lock";

  public AccountExperienceDutyOptimisticLockException() {
    super("Version of AccountExperienceDuty is invalid", DEFAULT_CODE);
  }
}
