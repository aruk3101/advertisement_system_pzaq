package com.draczek.SystemOgloszeniowy.accountCertificate.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AccountCertificate's invalid version exception.
 */
public class AccountCertificateOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "account_certificate_optimistic_lock";

  public AccountCertificateOptimisticLockException() {
    super("Version of AccountCertificate is invalid", DEFAULT_CODE);
  }
}
