package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.role.domain.command.RoleFacade;
import com.draczek.SystemOgloszeniowy.user.domain.command.JwtUtils;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionTokenFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Authentication Facade's config class.
 */
@Configuration
public class AuthenticationConfig {
  @Bean
  AuthenticationFacade authenticationFacade(
      AuthenticationManager authenticationManager,
      JwtUtils jwtUtils,
      PasswordEncoder passwordEncoder,
      RoleFacade roleFacade,
      UserFacade userFacade,
      UserActionTokenFacade userActionTokenFacade,
      JavaMailSender emailSender,
      SecurityFacade securityFacade) {

    LoginUseCase loginUseCase = new LoginUseCase(
        jwtUtils,
        authenticationManager);

    SendMailUseCase sendMailUseCase = new SendMailUseCase(emailSender);

    RegistrationValidationHelper registrationValidationHelper = new RegistrationValidationHelper(
        securityFacade,
        userFacade);
    RegistrationUseCase registrationUseCase = new RegistrationUseCase(
        registrationValidationHelper,
        passwordEncoder,
        roleFacade,
        userFacade,
        userActionTokenFacade,
        sendMailUseCase);

    ActivationUseCase activationUseCase = new ActivationUseCase(
        userActionTokenFacade,
        userFacade);

    StepOneResetPasswordUseCase stepOneResetPasswordUseCase = new StepOneResetPasswordUseCase(
        userFacade,
        userActionTokenFacade,
        sendMailUseCase
    );


    StepTwoResetPasswordValidationHelper stepTwoResetPasswordValidationHelper
        = new StepTwoResetPasswordValidationHelper(securityFacade);
    StepTwoResetPasswordUseCase stepTwoResetPasswordUseCase = new StepTwoResetPasswordUseCase(
        stepTwoResetPasswordValidationHelper,
        userFacade,
        userActionTokenFacade);

    return new AuthenticationFacade(
        loginUseCase,
        registrationUseCase,
        activationUseCase,
        stepOneResetPasswordUseCase,
        stepTwoResetPasswordUseCase);
  }
}
