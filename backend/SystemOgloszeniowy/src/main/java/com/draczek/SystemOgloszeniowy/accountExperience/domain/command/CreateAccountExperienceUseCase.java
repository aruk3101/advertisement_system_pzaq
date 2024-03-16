package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.AccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.CreateAccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command.AccountExperienceDuty;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command.AccountExperienceDutyFacade;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.CreateAccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Account experiences.
 */

@RequiredArgsConstructor
public class CreateAccountExperienceUseCase {
  private final SecurityFacade securityFacade;
  private final AccountExperienceRepository accountExperienceRepository;
  private final AccountExperienceMapper accountExperienceMapper;
  private final AccountExperienceDutyFacade accountExperienceDutyFacade;

  /**
   * Method for creating Account experiences.
   *
   * @param dto CreateAccountExperienceDto
   * @return AccountExperienceDto dto
   */
  public AccountExperienceDto createDto(CreateAccountExperienceDto dto) {
    return accountExperienceMapper.toDto(create(dto));
  }

  private AccountExperience create(CreateAccountExperienceDto dto) {
    AccountExperience accountExperience = AccountExperience.builder()
        .uuid(UUID.randomUUID())
        .periodEnd(dto.getPeriodEnd())
        .periodStart(dto.getPeriodStart())
        .account(securityFacade.getLoggedInAccount())
        .position(dto.getPosition())
        .companyName(dto.getCompanyName())
        .location(dto.getLocation())
        .build();
    accountExperience.setStatus(StatusEnum.ACTIVE);
    accountExperience.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountExperience.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    accountExperience = accountExperienceRepository.saveAndFlush(accountExperience);
    createAccountExperienceDuties(dto.getCreateAccountExperienceDutyDtos(), accountExperience);
    return accountExperience;
  }

  private List<AccountExperienceDuty> createAccountExperienceDuties(
      List<CreateAccountExperienceDutyDto> dtos,
      AccountExperience accountExperience) {
    return accountExperienceDutyFacade.create(dtos, accountExperience);
  }
}
