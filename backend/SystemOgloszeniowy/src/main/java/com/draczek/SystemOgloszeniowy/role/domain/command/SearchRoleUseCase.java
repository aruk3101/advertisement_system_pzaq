package com.draczek.SystemOgloszeniowy.role.domain.command;

import com.draczek.SystemOgloszeniowy.role.domain.enumerated.RoleEnum;
import lombok.RequiredArgsConstructor;

/**
 * Class for fetching roles.
 */
@RequiredArgsConstructor
class SearchRoleUseCase {
  private final RoleRepository roleRepository;

  /**
   * Method for fetching Role's name based on its name.
   *
   * @param roleEnum role enum
   * @return Role entity
   */
  public Role getEntity(RoleEnum roleEnum) {
    return roleRepository.get(roleEnum);
  }
}
