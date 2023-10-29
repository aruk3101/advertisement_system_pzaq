package com.draczek.SystemOgloszeniowy.auth;

import com.draczek.SystemOgloszeniowy.auth.command.domain.AuthenticationFacade;
import com.draczek.SystemOgloszeniowy.auth.command.dto.LoginDto;
import com.draczek.SystemOgloszeniowy.auth.command.dto.RegistrationDto;
import com.draczek.SystemOgloszeniowy.auth.command.dto.ResetPasswordStepTwoDto;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UserTokenDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Authentication package's controller.
 */
@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationFacade authenticationFacade;

  /**
   * Endpoint for logging in.
   */
  @PostMapping("/login")
  @Operation(summary = "Usługa od logowania")
  @ResponseStatus(HttpStatus.OK)
  public UserTokenDto login(@RequestBody LoginDto dto) {
    return authenticationFacade.login(dto);
  }

  /**
   * Endpoint for registration.
   */
  @PostMapping("/register")
  @Operation(summary = "Usługa do rejestracji")
  @ResponseStatus(HttpStatus.CREATED)
  public void register(@RequestBody RegistrationDto dto) {
    authenticationFacade.register(dto);
  }

  /**
   * Endpoint for activation of new, inactive account.
   */
  @PostMapping("/activate")
  @Operation(summary = "Usługa do aktywacji użytkownika")
  @ResponseStatus(HttpStatus.OK)
  public void activate(@RequestBody String token) {
    authenticationFacade.activate(token);
  }

  /**
   * Endpoint for step one of password reset process.
   */
  @PostMapping("/reset-password/step-1")
  @Operation(summary = "Usługa do resetu hasła - krok 1")
  @ResponseStatus(HttpStatus.OK)
  public void stepOnePasswordReset(@RequestBody String email) {
    authenticationFacade.stepOneResetPassword(email);
  }

  /**
   * Endpoint for step two of password reset process.
   */
  @PostMapping("/reset-password/step-2")
  @Operation(summary = "Usługa do resetu hasła - kork 2")
  @ResponseStatus(HttpStatus.OK)
  public void stepTwoPasswordReset(@RequestBody ResetPasswordStepTwoDto dto) {
    authenticationFacade.stepTwoResetPassword(dto);
  }

}
