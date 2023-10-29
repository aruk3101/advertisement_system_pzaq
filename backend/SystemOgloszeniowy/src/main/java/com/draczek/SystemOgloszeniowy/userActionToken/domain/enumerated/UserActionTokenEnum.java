package com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * User action token enum.
 */
@RequiredArgsConstructor
@Getter
public enum UserActionTokenEnum {
  ACTIVATE_ACCOUNT((short) 0),
  RESET_PASSWORD((short) 1);

  private final short value;
}
