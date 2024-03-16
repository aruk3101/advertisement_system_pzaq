package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.command.AccountExperienceFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Config class for AccountExperienceDutyFacade.
 */
@Configuration
public class AccountExperienceDutyConfig {
  @Bean
  AccountExperienceDutyFacade accountExperienceDutyFacade(
      AccountExperienceDutyRepository accountExperienceDutyRepository,
      SecurityFacade securityFacade,
      @Lazy AccountExperienceFacade accountExperienceFacade
  ) {
    AccountExperienceDutyMapper accountExperienceDutyMapper
        = Mappers.getMapper(AccountExperienceDutyMapper.class);

    CreateAccountExperienceDutyUseCase createAccountExperienceDutyUseCase
        = new CreateAccountExperienceDutyUseCase(
        securityFacade,
        accountExperienceFacade,
        accountExperienceDutyRepository,
        accountExperienceDutyMapper);

    DeleteAccountExperienceDutyUseCase deleteAccountEducationsUseCase
        = new DeleteAccountExperienceDutyUseCase(
        accountExperienceDutyRepository,
        securityFacade);

    UpdateAccountExperienceDutyUseCase updateAccountExperienceDutyUseCase
        = new UpdateAccountExperienceDutyUseCase(
        accountExperienceDutyRepository,
        securityFacade,
        accountExperienceDutyMapper);

    return new AccountExperienceDutyFacade(
        createAccountExperienceDutyUseCase,
        deleteAccountEducationsUseCase,
        updateAccountExperienceDutyUseCase
    );
  }
}
