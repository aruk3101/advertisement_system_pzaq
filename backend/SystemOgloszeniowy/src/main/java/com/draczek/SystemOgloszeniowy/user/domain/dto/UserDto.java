package com.draczek.SystemOgloszeniowy.user.domain.dto;

import com.draczek.SystemOgloszeniowy.role.domain.dto.RoleDto;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * User's entity dto.
 */
@Value
public class UserDto {

  UUID uuid;

  String firstName;

  String lastName;

  boolean account;

  String username;

  boolean enabled;

  Set<RoleDto> roles = new HashSet<>();

  @NotNull
  Integer version;
}
