package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.auth.command.dto.LoginDto;
import com.draczek.SystemOgloszeniowy.auth.command.dto.RegistrationDto;
import com.draczek.SystemOgloszeniowy.auth.command.dto.ResetPasswordStepTwoDto;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UserTokenDto;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Authentication's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AuthenticationFacade {

  private final LoginUseCase loginUseCase;
  private final RegistrationUseCase registrationUseCase;
  private final ActivationUseCase activationUseCase;
  private final StepOneResetPasswordUseCase stepOneResetPasswordUseCase;
  private final StepTwoResetPasswordUseCase stepTwoResetPasswordUseCase;

  /**
   * Service for user login.
   *
   * @param dto LoginDto
   * @return User authentication token dto
   */
  public UserTokenDto login(@Valid @NotNull LoginDto dto) {
    return loginUseCase.login(dto);
  }

  /**
   * Service for user registration.
   *
   * @param dto RegistrationDto
   */
  public void register(@Valid @NotNull RegistrationDto dto) {
    registrationUseCase.registration(dto);
  }

  /**
   * Service for activation of new, inactive user.
   *
   * @param token token key
   */
  public void activate(String token) {
    activationUseCase.activate(token);
  }

  /**
   * Step one of password reset process.
   *
   * @param email user's email
   */
  public void stepOneResetPassword(@NotBlank @Email String email) {
    stepOneResetPasswordUseCase.reset(email);
  }

  public void stepTwoResetPassword(@NotNull ResetPasswordStepTwoDto dto) {
    stepTwoResetPasswordUseCase.reset(dto);
  }
}
