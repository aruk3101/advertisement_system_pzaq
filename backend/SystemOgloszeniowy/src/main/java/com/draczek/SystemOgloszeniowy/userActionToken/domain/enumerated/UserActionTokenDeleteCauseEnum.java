package com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of UserActionToken delete cause.
 */
@Getter
@RequiredArgsConstructor
public enum  UserActionTokenDeleteCauseEnum {
  USED((short) 0),
  EXPIRED((short) 1);

  private final short value;
}
