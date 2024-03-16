package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AccountExperience entities.
 */
@RequiredArgsConstructor
public class DeleteAccountExperienceUseCase {
  private final AccountExperienceRepository accountExperienceRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for deleting AccountExperience entities by its UUID.
   *
   * @param uuid AccountExperience's UUID
   */
  public void delete(UUID uuid) {
    AccountExperience accountExperience = accountExperienceRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountExperienceRepository.delete(accountExperience);
  }

}
