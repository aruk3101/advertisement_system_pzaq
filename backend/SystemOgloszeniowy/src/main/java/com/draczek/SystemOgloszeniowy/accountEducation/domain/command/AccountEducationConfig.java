package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.command.EducationLevelFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AccountEducationFacade.
 */
@Configuration
public class AccountEducationConfig {
  @Bean
  AccountEducationFacade accountEducationFacade(
      AccountEducationRepository accountEducationRepository,
      SecurityFacade securityFacade,
      EducationLevelFacade educationLevelFacade
  ) {
    AccountEducationMapper accountEducationMapper
        = Mappers.getMapper(AccountEducationMapper.class);

    SearchAccountEducationUseCase searchAccountEducationUseCase
        = new SearchAccountEducationUseCase(
        accountEducationMapper,
        accountEducationRepository,
        securityFacade);

    CreateAccountEducationUseCase createAccountEducationUseCase
        = new CreateAccountEducationUseCase(
        securityFacade,
        accountEducationRepository,
        accountEducationMapper,
        educationLevelFacade);

    DeleteAccountEducationsUseCase deleteAccountEducationsUseCase
        = new DeleteAccountEducationsUseCase(
        accountEducationRepository,
        securityFacade);

    UpdateAccountEducationUseCase updateAccountEducationUseCase
        = new UpdateAccountEducationUseCase(
        accountEducationRepository,
        securityFacade,
        accountEducationMapper,
        educationLevelFacade);

    return new AccountEducationFacade(
        searchAccountEducationUseCase,
        createAccountEducationUseCase,
        deleteAccountEducationsUseCase,
        updateAccountEducationUseCase);
  }
}


