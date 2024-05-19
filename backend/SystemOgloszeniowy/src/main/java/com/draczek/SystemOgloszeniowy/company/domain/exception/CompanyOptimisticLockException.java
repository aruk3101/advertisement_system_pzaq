package com.draczek.SystemOgloszeniowy.company.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of Company's invalid version exception.
 */
public class CompanyOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "company_optimistic_lock";

  public CompanyOptimisticLockException() {
    super("Version of Company is invalid", DEFAULT_CODE);
  }
}
