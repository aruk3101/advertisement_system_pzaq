package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AccountSkill entities.
 */
@RequiredArgsConstructor
public class DeleteAccountSkillUseCase {
  private final AccountSkillRepository accountSkillRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for deleting AccountSkill by its UUID.
   *
   * @param uuid AccountSkill's UUID
   */
  public void delete(UUID uuid) {
    AccountSkill accountLink = accountSkillRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountSkillRepository.delete(accountLink);
  }

}
