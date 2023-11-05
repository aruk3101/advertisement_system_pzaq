package com.draczek.SystemOgloszeniowy.auth.command.dto;

import javax.validation.constraints.NotBlank;
import lombok.Value;

/**
 * Step two of password reset process dto.
 */
@Value
public class ResetPasswordStepTwoDto {
  @NotBlank
  String key;

  @NotBlank
  String password;

  @NotBlank
  String confirmPassword;

}
