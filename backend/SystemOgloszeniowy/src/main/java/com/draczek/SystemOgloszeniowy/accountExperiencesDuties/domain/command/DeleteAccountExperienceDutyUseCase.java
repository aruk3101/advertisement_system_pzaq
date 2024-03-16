package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AccountExperienceDuty entities.
 */
@RequiredArgsConstructor
public class DeleteAccountExperienceDutyUseCase {
  private final AccountExperienceDutyRepository accountExperienceDutyRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for deleting AccountExperienceDuty entities by its UUID.
   *
   * @param uuid AccountExperienceDuty's UUID
   */
  public void delete(UUID uuid) {
    AccountExperienceDuty accountExperienceDuty = accountExperienceDutyRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountExperienceDutyRepository.delete(accountExperienceDuty);
  }

}
