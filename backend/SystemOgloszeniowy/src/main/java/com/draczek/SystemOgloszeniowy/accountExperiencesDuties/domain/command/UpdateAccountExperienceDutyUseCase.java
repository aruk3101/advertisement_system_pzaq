package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.AccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.UpdateAccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Account experience duties.
 */
@RequiredArgsConstructor
public class UpdateAccountExperienceDutyUseCase {
  private final AccountExperienceDutyRepository accountExperienceDutyRepository;
  private final SecurityFacade securityFacade;
  private final AccountExperienceDutyMapper accountExperienceDutyMapper;

  /**
   * Method for updating AccountExperienceDuties.
   *
   * @param uuid AccountExperienceDuty's UUID
   * @param dto  UpdateAccountExperienceDutyDto
   * @return modified AccountExperienceDutyDto
   */
  public AccountExperienceDutyDto updateDto(UUID uuid, UpdateAccountExperienceDutyDto dto) {
    return accountExperienceDutyMapper.toDto(update(uuid, dto));
  }

  private AccountExperienceDuty update(UUID uuid, UpdateAccountExperienceDutyDto dto) {
    AccountExperienceDuty accountExperienceDuty = accountExperienceDutyRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountExperienceDuty.setDuty(dto.getDuty());
    accountExperienceDuty.setVersion(dto.getVersion());
    accountExperienceDuty.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountExperienceDutyRepository.saveAndFlush(accountExperienceDuty);
  }
}
