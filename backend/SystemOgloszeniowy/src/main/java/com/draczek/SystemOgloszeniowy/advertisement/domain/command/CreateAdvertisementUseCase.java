package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.AdvertisementDto;
import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.CreateAdvertisementDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.company.domain.command.CompanyFacade;
import com.draczek.SystemOgloszeniowy.contractType.domain.command.ContractTypeFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.jobType.domain.command.JobTypeFacade;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.command.PositionLevelFacade;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.command.WorkingTimeTypeFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Advertisements.
 */

@RequiredArgsConstructor
public class CreateAdvertisementUseCase {
  private final SecurityFacade securityFacade;
  private final AdvertisementRepository advertisementRepository;
  private final AdvertisementMapper advertisementMapper;
  private final CompanyFacade companyFacade;
  private final PositionLevelFacade positionLevelFacade;
  private final ContractTypeFacade contractTypeFacade;
  private final WorkingTimeTypeFacade workingTimeTypeFacade;
  private final JobTypeFacade jobTypeFacade;

  /**
   * Method for creating Advertisement.
   *
   * @param dto CreateAdvertisementDto
   * @return AdvertisementDto dto
   */
  public AdvertisementDto createAdvertisementDto(CreateAdvertisementDto dto) {
    return advertisementMapper.toDto(createLanguageLevel(dto));
  }

  private Advertisement createLanguageLevel(CreateAdvertisementDto dto) {
    Advertisement positionLevel = Advertisement.builder()
        .uuid(UUID.randomUUID())
        .position(dto.getPosition())
        .salaryFrom(dto.getSalaryFrom())
        .salaryTo(dto.getSalaryTo())
        .workingDays(dto.getWorkingDays())
        .workingHours(dto.getWorkingHours())
        .expirationDate(dto.getExpirationDate())
        .company(companyFacade.get(dto.getCompanyUuid()))
        .positionLevel(positionLevelFacade.getEntity(dto.getPositionLevelUuid()))
        .contractType(contractTypeFacade.getEntity(dto.getContractTypeUuid()))
        .workingTimeType(workingTimeTypeFacade.getEntity(dto.getWorkingTimeTypeUuid()))
        .jobType(jobTypeFacade.getEntity(dto.getJobTypeUuid()))
        .build();
    positionLevel.setStatus(StatusEnum.ACTIVE);
    positionLevel.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    positionLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementRepository.saveAndFlush(positionLevel);
  }
}
