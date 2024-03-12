package com.draczek.SystemOgloszeniowy.accountSkill.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AccountSkill's invalid version exception.
 */
public class AccountSkillOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "account_skill_optimistic_lock";

  public AccountSkillOptimisticLockException() {
    super("Version of AccountSkill is invalid", DEFAULT_CODE);
  }
}
