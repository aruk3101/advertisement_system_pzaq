package com.draczek.SystemOgloszeniowy.role.domain.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum role.
 */
@Getter
@RequiredArgsConstructor
public enum RoleEnum {
  SUPER_ADMIN("SUPER_ADMIN"),
  ADMIN("ADMIN"),
  USER("USER");

  private final String value;
}