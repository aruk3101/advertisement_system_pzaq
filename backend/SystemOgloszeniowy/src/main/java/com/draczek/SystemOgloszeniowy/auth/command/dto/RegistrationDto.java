package com.draczek.SystemOgloszeniowy.auth.command.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Value;

/**
 * User registration dto.
 */
@Value
public class RegistrationDto {
  @NotBlank
  @Email
  String username;

  @NotBlank
  String password;

  @NotBlank
  String confirmPassword;
}
