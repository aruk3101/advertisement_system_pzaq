package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command.AccountExperienceDutyFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AccountExperienceFacade.
 */
@Configuration
public class AccountExperienceConfig {
  @Bean
  AccountExperienceFacade accountExperienceFacade(
      AccountExperienceRepository accountExperienceRepository,
      SecurityFacade securityFacade,
      AccountExperienceDutyFacade accountExperienceDutyFacade) {
    AccountExperienceMapper accountExperienceMapper
        = Mappers.getMapper(AccountExperienceMapper.class);

    SearchAccountExperienceUseCase searchAccountExperienceUseCase
        = new SearchAccountExperienceUseCase(
        accountExperienceMapper,
        accountExperienceRepository,
        securityFacade);

    CreateAccountExperienceUseCase createAccountExperienceUseCase
        = new CreateAccountExperienceUseCase(
        securityFacade,
        accountExperienceRepository,
        accountExperienceMapper,
        accountExperienceDutyFacade);

    DeleteAccountExperienceUseCase deleteAccountExperienceUseCase
        = new DeleteAccountExperienceUseCase(
        accountExperienceRepository,
        securityFacade);

    UpdateAccountExperienceUseCase updateAccountExperienceUseCase
        = new UpdateAccountExperienceUseCase(
        accountExperienceRepository,
        securityFacade,
        accountExperienceMapper);

    return new AccountExperienceFacade(
        searchAccountExperienceUseCase,
        createAccountExperienceUseCase,
        deleteAccountExperienceUseCase,
        updateAccountExperienceUseCase
    );
  }
}
