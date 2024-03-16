package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.command.LanguageLevelFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AccountLanguageFacade.
 */
@Configuration
public class AccountLanguageConfig {
  @Bean
  AccountLanguageFacade accountLanguageFacade(
      AccountLanguageRepository accountLanguageRepository,
      SecurityFacade securityFacade,
      LanguageLevelFacade languageLevelFacade
  ) {
    AccountLanguageMapper accountEducationMapper
        = Mappers.getMapper(AccountLanguageMapper.class);

    SearchAccountLanguageUseCase searchAccountLanguageUseCase
        = new SearchAccountLanguageUseCase(
        accountEducationMapper,
        accountLanguageRepository,
        securityFacade);

    CreateAccountLanguageUseCase createAccountLanguageUseCase
        = new CreateAccountLanguageUseCase(
        securityFacade,
        accountLanguageRepository,
        accountEducationMapper,
        languageLevelFacade);

    DeleteAccountLanguageUseCase deleteAccountLanguageUseCase
        = new DeleteAccountLanguageUseCase(
        accountLanguageRepository,
        securityFacade);

    UpdateAccountLanguageUseCase updateAccountLanguageUseCase
        = new UpdateAccountLanguageUseCase(
        accountLanguageRepository,
        securityFacade,
        accountEducationMapper,
        languageLevelFacade);

    return new AccountLanguageFacade(
        searchAccountLanguageUseCase,
        createAccountLanguageUseCase,
        deleteAccountLanguageUseCase,
        updateAccountLanguageUseCase);
  }
}
