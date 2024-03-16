package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.AccountLanguageDto;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.UpdateAccountLanguageDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.command.LanguageLevelFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Account languages.
 */
@RequiredArgsConstructor
public class UpdateAccountLanguageUseCase {
  private final AccountLanguageRepository accountLanguageRepository;
  private final SecurityFacade securityFacade;
  private final AccountLanguageMapper accountLanguageMapper;
  private final LanguageLevelFacade languageLevelFacade;

  /**
   * Method for updating AccountLanguages.
   *
   * @param uuid AccountLanguage's UUID
   * @param dto  UpdateAccountLanguageDto
   * @return modified AccountLanguage
   */
  public AccountLanguageDto updateDto(UUID uuid, UpdateAccountLanguageDto dto) {
    return accountLanguageMapper.toDto(update(uuid, dto));
  }

  private AccountLanguage update(UUID uuid, UpdateAccountLanguageDto dto) {
    AccountLanguage accountLanguage = accountLanguageRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountLanguage.setLanguageLevel(languageLevelFacade.getEntity(dto.getLanguageLevelUuid()));
    accountLanguage.setLanguage(dto.getLanguage());
    accountLanguage.setVersion(dto.getVersion());
    accountLanguage.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountLanguageRepository.saveAndFlush(accountLanguage);
  }
}
