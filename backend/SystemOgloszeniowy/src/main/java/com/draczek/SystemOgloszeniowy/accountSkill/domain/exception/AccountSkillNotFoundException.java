package com.draczek.SystemOgloszeniowy.accountSkill.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AccountSkillNotFoundException entity not found exception.
 */
public final class AccountSkillNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "account_skill_not_found";

  public AccountSkillNotFoundException(UUID uuid) {
    super(String.format("Could not find Account Skill with UUID: %s", uuid), DEFAULT_CODE);
  }
}
