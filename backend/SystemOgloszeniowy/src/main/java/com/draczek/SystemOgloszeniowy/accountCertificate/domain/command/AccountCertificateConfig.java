package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AccountCertificateFacade.
 */
@Configuration
public class AccountCertificateConfig {
  @Bean
  AccountCertificateFacade accountCertificateFacade(
      AccountCertificateRepository accountCertificateRepository,
      SecurityFacade securityFacade
  ) {
    AccountCertificateMapper accountCertificateMapper
        = Mappers.getMapper(AccountCertificateMapper.class);

    SearchAccountCertificateUseCase searchAccountCertificateUseCase
        = new SearchAccountCertificateUseCase(
        accountCertificateMapper,
        accountCertificateRepository,
        securityFacade);

    CreateAccountCertificateUseCase createAccountCertificateUseCase
        = new CreateAccountCertificateUseCase(
        securityFacade,
        accountCertificateRepository,
        accountCertificateMapper);

    DeleteAccountCertificateUseCase deleteAccountCertificateUseCase
        = new DeleteAccountCertificateUseCase(
        accountCertificateRepository,
        securityFacade);

    UpdateAccountCertificateUseCase updateAccountCertificateUseCase
        = new UpdateAccountCertificateUseCase(
        accountCertificateRepository,
        securityFacade,
        accountCertificateMapper);

    return new AccountCertificateFacade(
        searchAccountCertificateUseCase,
        createAccountCertificateUseCase,
        deleteAccountCertificateUseCase,
        updateAccountCertificateUseCase);
  }
}
