package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.AccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.UpdateAccountExperienceDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Account experiences.
 */
@RequiredArgsConstructor
public class UpdateAccountExperienceUseCase {
  private final AccountExperienceRepository accountExperienceRepository;
  private final SecurityFacade securityFacade;
  private final AccountExperienceMapper accountExperienceMapper;

  /**
   * Method for updating AccountExperience.
   *
   * @param uuid AccountExperience's UUID
   * @param dto  UpdateAccountExperienceDto
   * @return modified AccountExperienceDto
   */
  public AccountExperienceDto updateDto(UUID uuid, UpdateAccountExperienceDto dto) {
    return accountExperienceMapper.toDto(update(uuid, dto));
  }

  private AccountExperience update(UUID uuid, UpdateAccountExperienceDto dto) {
    AccountExperience accountExperience = accountExperienceRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountExperience.setPeriodEnd(dto.getPeriodEnd());
    accountExperience.setPeriodStart(dto.getPeriodStart());
    accountExperience.setVersion(dto.getVersion());
    accountExperience.setPosition(dto.getPosition());
    accountExperience.setCompanyName(dto.getCompanyName());
    accountExperience.setLocation(dto.getLocation());
    accountExperience.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountExperienceRepository.saveAndFlush(accountExperience);
  }
}
