package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AccountLanguage entities.
 */
@RequiredArgsConstructor
public class DeleteAccountLanguageUseCase {
  private final AccountLanguageRepository accountLanguageRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for deleting AccountLanguage entities by its UUID.
   *
   * @param uuid AccountLanguage's UUID
   */
  public void delete(UUID uuid) {
    AccountLanguage accountEducation = accountLanguageRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountLanguageRepository.delete(accountEducation);
  }
}
