package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AccountEducation entities.
 */
@RequiredArgsConstructor
public class DeleteAccountEducationsUseCase {
  private final AccountEducationRepository accountEducationRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for deleting AccountEducation entities by its UUID.
   *
   * @param uuid AccountEducation's UUID
   */
  public void delete(UUID uuid) {
    AccountEducation accountEducation = accountEducationRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountEducationRepository.delete(accountEducation);
  }

}
