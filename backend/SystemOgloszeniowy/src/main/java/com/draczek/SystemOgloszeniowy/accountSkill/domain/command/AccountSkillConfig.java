package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AccountSkillFacade.
 */
@Configuration
public class AccountSkillConfig {
  @Bean
  AccountSkillFacade accountSkillFacade(
      AccountSkillRepository accountSkillRepository,
      SecurityFacade securityFacade
  ) {
    AccountSkillMapper accountSkillMapper
        = Mappers.getMapper(AccountSkillMapper.class);

    SearchAccountSkillUseCase searchAccountSkillUseCase
        = new SearchAccountSkillUseCase(
        accountSkillMapper,
        accountSkillRepository,
        securityFacade);

    CreateAccountSkillUseCase createAccountSkillUseCase
        = new CreateAccountSkillUseCase(
        securityFacade,
        accountSkillRepository,
        accountSkillMapper);

    DeleteAccountSkillUseCase deleteAccountSkillUseCase
        = new DeleteAccountSkillUseCase(
        accountSkillRepository,
        securityFacade);

    UpdateAccountSkillUseCase updateAccountSkillUseCase
        = new UpdateAccountSkillUseCase(
        accountSkillRepository,
        securityFacade,
        accountSkillMapper);

    return new AccountSkillFacade(
        searchAccountSkillUseCase,
        createAccountSkillUseCase,
        deleteAccountSkillUseCase,
        updateAccountSkillUseCase);
  }
}
