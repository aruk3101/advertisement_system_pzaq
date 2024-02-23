package com.draczek.SystemOgloszeniowy.accountEducation.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AccountEducation's invalid version exception.
 */
public class AccountEducationOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "account_education_optimistic_lock";

  public AccountEducationOptimisticLockException() {
    super("Version of AccountEducation is invalid", DEFAULT_CODE);
  }
}

