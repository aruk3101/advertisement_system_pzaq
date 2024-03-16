package com.draczek.SystemOgloszeniowy.accountLink.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AccountLink's invalid version exception.
 */
public class AccountLinkOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "account_link_optimistic_lock";

  public AccountLinkOptimisticLockException() {
    super("Version of AccountLink is invalid", DEFAULT_CODE);
  }
}

