package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.AccountEducationDto;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.CreateAccountEducationDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.command.EducationLevelFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Account educations.
 */

@RequiredArgsConstructor
public class CreateAccountEducationUseCase {
  private final SecurityFacade securityFacade;
  private final AccountEducationRepository accountEducationRepository;
  private final AccountEducationMapper accountEducationMapper;
  private final EducationLevelFacade educationLevelFacade;

  /**
   * Method for creating Account educations.
   *
   * @param dto CreateAccountEducationDto
   * @return AccountEducationDto dto
   */
  public AccountEducationDto createDto(CreateAccountEducationDto dto) {
    return accountEducationMapper.toDto(create(dto));
  }

  private AccountEducation create(CreateAccountEducationDto dto) {
    AccountEducation accountEducation = AccountEducation.builder()
        .uuid(UUID.randomUUID())
        .educationLevel(educationLevelFacade.getEntity(dto.getEducationLevelUuid()))
        .periodEnd(dto.getPeriodEnd())
        .periodStart(dto.getPeriodStart())
        .schoolLocation(dto.getSchoolLocation())
        .schoolName(dto.getSchoolName())
        .specialization(dto.getSpecialization())
        .account(securityFacade.getLoggedInAccount())
        .build();
    accountEducation.setStatus(StatusEnum.ACTIVE);
    accountEducation.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountEducation.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountEducationRepository.saveAndFlush(accountEducation);
  }
}
