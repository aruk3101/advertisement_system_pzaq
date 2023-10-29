package com.draczek.SystemOgloszeniowy.auth.command.dto;

import javax.validation.constraints.NotBlank;
import lombok.Value;

/**
 * Login dto.
 */
@Value
public class LoginDto {

  @NotBlank
  String username;

  @NotBlank
  String password;
}
