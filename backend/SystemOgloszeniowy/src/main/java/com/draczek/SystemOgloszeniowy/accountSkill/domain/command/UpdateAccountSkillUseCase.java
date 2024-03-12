package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.AccountSkillDto;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.UpdateAccountSkillDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Account skills.
 */
@RequiredArgsConstructor
public class UpdateAccountSkillUseCase {
  private final AccountSkillRepository accountSkillRepository;
  private final SecurityFacade securityFacade;
  private final AccountSkillMapper accountSkillMapper;

  /**
   * Method for updating AccountSkills.
   *
   * @param uuid AccountSkill's UUID
   * @param dto  UpdateAccountSkillDto
   * @return modified AccountSkillDto
   */
  public AccountSkillDto updateDto(UUID uuid, UpdateAccountSkillDto dto) {
    return accountSkillMapper.toDto(update(uuid, dto));
  }

  private AccountSkill update(UUID uuid, UpdateAccountSkillDto dto) {
    AccountSkill accountSkill = accountSkillRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountSkill.setSkillName(dto.getSkillName());
    accountSkill.setVersion(dto.getVersion());
    accountSkill.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountSkillRepository.saveAndFlush(accountSkill);
  }
}
