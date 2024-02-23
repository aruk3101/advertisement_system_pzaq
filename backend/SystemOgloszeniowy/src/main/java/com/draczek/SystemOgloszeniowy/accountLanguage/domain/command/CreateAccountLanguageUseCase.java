package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.AccountLanguageDto;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.CreateAccountLanguageDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.command.LanguageLevelFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Account languages.
 */

@RequiredArgsConstructor
public class CreateAccountLanguageUseCase {
  private final SecurityFacade securityFacade;
  private final AccountLanguageRepository accountLanguageRepository;
  private final AccountLanguageMapper accountLanguageMapper;
  private final LanguageLevelFacade languageLevelFacade;

  /**
   * Method for creating Account languages.
   *
   * @param dto CreateAccountLanguageDto
   * @return AccountLanguageDto dto
   */
  public AccountLanguageDto createDto(CreateAccountLanguageDto dto) {
    return accountLanguageMapper.toDto(create(dto));
  }

  private AccountLanguage create(CreateAccountLanguageDto dto) {
    AccountLanguage accountLanguage = AccountLanguage.builder()
        .uuid(UUID.randomUUID())
        .languageLevel(languageLevelFacade.getEntity(dto.getLanguageLevelUuid()))
        .language(dto.getLanguage())
        .account(securityFacade.getLoggedInAccount())
        .build();
    accountLanguage.setStatus(StatusEnum.ACTIVE);
    accountLanguage.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountLanguage.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountLanguageRepository.saveAndFlush(accountLanguage);
  }
}
