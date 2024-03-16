package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.AccountEducationDto;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.UpdateAccountEducationDto;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.command.EducationLevelFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Account educations.
 */
@RequiredArgsConstructor
public class UpdateAccountEducationUseCase {
  private final AccountEducationRepository accountEducationRepository;
  private final SecurityFacade securityFacade;
  private final AccountEducationMapper accountEducationMapper;
  private final EducationLevelFacade educationLevelFacade;

  /**
   * Method for updating AccountEducations.
   *
   * @param uuid AccountEducation's UUID
   * @param dto UpdateAccountEducationDto
   * @return modified AccountEducationDto
   */
  public AccountEducationDto updateDto(UUID uuid, UpdateAccountEducationDto dto) {
    return accountEducationMapper.toDto(update(uuid, dto));
  }

  private AccountEducation update(UUID uuid, UpdateAccountEducationDto dto) {
    AccountEducation accountEducation = accountEducationRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountEducation.setEducationLevel(educationLevelFacade.getEntity(dto.getEducationLevelUuid()));
    accountEducation.setPeriodEnd(dto.getPeriodEnd());
    accountEducation.setPeriodStart(dto.getPeriodStart());
    accountEducation.setSchoolLocation(dto.getSchoolLocation());
    accountEducation.setSchoolName(dto.getSchoolName());
    accountEducation.setSpecialization(dto.getSpecialization());
    accountEducation.setVersion(dto.getVersion());
    accountEducation.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountEducationRepository.saveAndFlush(accountEducation);
  }
}
