package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.command.AccountExperience;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.command.AccountExperienceFacade;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.AccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.CreateAccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Account experience duties.
 */

@RequiredArgsConstructor
public class CreateAccountExperienceDutyUseCase {
  private final SecurityFacade securityFacade;
  private final AccountExperienceFacade accountExperienceFacade;
  private final AccountExperienceDutyRepository accountExperienceDutyRepository;
  private final AccountExperienceDutyMapper accountExperienceDutyMapper;

  /**
   * Method for creating Account experience duties.
   *
   * @param dto CreateAccountExperienceDutyDto
   * @return AccountExperienceDutyDto dto
   */
  public AccountExperienceDutyDto createDto(CreateAccountExperienceDutyDto dto) {
    return accountExperienceDutyMapper.toDto(create(dto));
  }

  /**
   * Method for creating AccountExperienceDuties.
   *
   * @param dtos              list of CreateAccountExperienceDutyDto
   * @param accountExperience linked AccountExperience
   * @return list of AccountExperienceDuty entities
   */
  public List<AccountExperienceDuty> create(List<CreateAccountExperienceDutyDto> dtos,
                                            AccountExperience accountExperience) {
    List<AccountExperienceDuty> duties = dtos.stream().map(duty -> create(duty, accountExperience))
        .toList();
    accountExperience.setAccountExperienceDuties(duties);
    return duties;
  }

  private AccountExperienceDuty create(CreateAccountExperienceDutyDto dto) {
    AccountExperienceDuty accountExperienceDuty = AccountExperienceDuty.builder()
        .uuid(UUID.randomUUID())
        .accountExperience(accountExperienceFacade.getEntity(dto.getAccountExperienceUuid()))
        .duty(dto.getDuty())
        .build();
    accountExperienceDuty.setStatus(StatusEnum.ACTIVE);
    accountExperienceDuty.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountExperienceDuty.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountExperienceDutyRepository.saveAndFlush(accountExperienceDuty);
  }

  private AccountExperienceDuty create(CreateAccountExperienceDutyDto dto,
                                       AccountExperience accountExperience) {
    AccountExperienceDuty accountExperienceDuty = AccountExperienceDuty.builder()
        .uuid(UUID.randomUUID())
        .accountExperience(accountExperience)
        .duty(dto.getDuty())
        .build();
    accountExperienceDuty.setStatus(StatusEnum.ACTIVE);
    accountExperienceDuty.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountExperienceDuty.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountExperienceDutyRepository.saveAndFlush(accountExperienceDuty);
  }
}
