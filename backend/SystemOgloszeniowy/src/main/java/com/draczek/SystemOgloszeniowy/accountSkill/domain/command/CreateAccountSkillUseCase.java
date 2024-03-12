package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.AccountSkillDto;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.CreateAccountSkillDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Account skills.
 */

@RequiredArgsConstructor
public class CreateAccountSkillUseCase {
  private final SecurityFacade securityFacade;
  private final AccountSkillRepository accountSkillRepository;
  private final AccountSkillMapper accountSkillMapper;

  /**
   * Method for creating Account skills.
   *
   * @param dto CreateAccountSkillDto
   * @return AccountSkillDto dto
   */
  public AccountSkillDto createDto(CreateAccountSkillDto dto) {
    return accountSkillMapper.toDto(create(dto));
  }

  private AccountSkill create(CreateAccountSkillDto dto) {
    AccountSkill accountSkill = AccountSkill.builder()
        .uuid(UUID.randomUUID())
        .skillName(dto.getSkillName())
        .account(securityFacade.getLoggedInAccount())
        .build();
    accountSkill.setStatus(StatusEnum.ACTIVE);
    accountSkill.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountSkill.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountSkillRepository.saveAndFlush(accountSkill);
  }
}
