package com.draczek.SystemOgloszeniowy.userActionToken.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;

/**
 * UserActionToken not found exception.
 */
public class UserActionTokenNotFoundException extends EntityNotFoundException {
  private static final String DEFAULT_CODE = "user_action_token_not_found";

  public UserActionTokenNotFoundException(String key) {
    super(String.format("Could not find UserActionToken with key: %s", key), DEFAULT_CODE);
  }
}
