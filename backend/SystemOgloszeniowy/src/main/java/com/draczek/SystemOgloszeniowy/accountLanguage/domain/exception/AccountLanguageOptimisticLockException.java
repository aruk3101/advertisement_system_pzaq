package com.draczek.SystemOgloszeniowy.accountLanguage.domain.exception;


import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AccountLanguage's invalid version exception.
 */
public class AccountLanguageOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "account_language_optimistic_lock";

  public AccountLanguageOptimisticLockException() {
    super("Version of AccountLanguage is invalid", DEFAULT_CODE);
  }
}

