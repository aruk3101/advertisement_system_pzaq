package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AccountLinkFacade.
 */
@Configuration
public class AccountLinkConfig {
  @Bean
  AccountLinkFacade accountLinkFacade(
      AccountLinkRepository accountLinkRepository,
      SecurityFacade securityFacade
  ) {
    AccountLinkMapper accountLinkMapper
        = Mappers.getMapper(AccountLinkMapper.class);

    SearchAccountLinkUseCase searchAccountLinkUseCase
        = new SearchAccountLinkUseCase(
        accountLinkMapper,
        accountLinkRepository,
        securityFacade);

    CreateAccountLinkUseCase createAccountLinkUseCase
        = new CreateAccountLinkUseCase(
        securityFacade,
        accountLinkRepository,
        accountLinkMapper);

    DeleteAccountLinkUseCase deleteAccountLinkUseCase
        = new DeleteAccountLinkUseCase(
        accountLinkRepository,
        securityFacade);

    UpdateAccountLinkUseCase updateAccountLinkUseCase
        = new UpdateAccountLinkUseCase(
        accountLinkRepository,
        securityFacade,
        accountLinkMapper);

    return new AccountLinkFacade(
        searchAccountLinkUseCase,
        createAccountLinkUseCase,
        deleteAccountLinkUseCase,
        updateAccountLinkUseCase);
  }
}
