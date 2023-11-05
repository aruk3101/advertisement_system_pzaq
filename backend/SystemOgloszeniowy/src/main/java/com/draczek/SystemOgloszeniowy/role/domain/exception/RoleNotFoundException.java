package com.draczek.SystemOgloszeniowy.role.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;

/**
 * Role not found custom exception.
 */
public final class RoleNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "role_not_found";

  public RoleNotFoundException(String name) {
    super(String.format("Could not find Role with name: %s", name), DEFAULT_CODE);
  }
}
