package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.AdvertisementDto;
import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.UpdateAdvertisementDto;
import com.draczek.SystemOgloszeniowy.company.domain.command.CompanyFacade;
import com.draczek.SystemOgloszeniowy.contractType.domain.command.ContractTypeFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.jobType.domain.command.JobTypeFacade;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.command.PositionLevelFacade;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.command.WorkingTimeTypeFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Advertisements.
 */
@RequiredArgsConstructor
public class UpdateAdvertisementUseCase {
  private final AdvertisementRepository advertisementRepository;
  private final SecurityFacade securityFacade;
  private final AdvertisementMapper advertisementMapper;
  private final PositionLevelFacade positionLevelFacade;
  private final ContractTypeFacade contractTypeFacade;
  private final WorkingTimeTypeFacade workingTimeTypeFacade;
  private final JobTypeFacade jobTypeFacade;

  /**
   * Method for updating Advertisement.
   *
   * @param uuid Advertisement's UUID
   * @param dto  UpdateAdvertisementDto
   * @return modified AdvertisementDto
   */
  public AdvertisementDto updateDto(UUID uuid, UpdateAdvertisementDto dto) {
    return advertisementMapper.toDto(update(uuid, dto));
  }

  private Advertisement update(UUID uuid, UpdateAdvertisementDto dto) {
    Advertisement advertisement = advertisementRepository.get(uuid);
    advertisement.setPosition(dto.getPosition());
    advertisement.setSalaryFrom(dto.getSalaryFrom());
    advertisement.setSalaryTo(dto.getSalaryTo());
    advertisement.setWorkingDays(dto.getWorkingDays());
    advertisement.setWorkingHours(dto.getWorkingHours());
    advertisement.setExpirationDate(dto.getExpirationDate());
    advertisement.setPositionLevel(positionLevelFacade.getEntity(dto.getPositionLevelUuid()));
    advertisement.setContractType(contractTypeFacade.getEntity(dto.getContractTypeUuid()));
    advertisement.setWorkingTimeType(workingTimeTypeFacade.getEntity(dto.getWorkingTimeTypeUuid()));
    advertisement.setJobType(jobTypeFacade.getEntity(dto.getJobTypeUuid()));
    advertisement.setVersion(dto.getVersion());
    advertisement.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementRepository.saveAndFlush(advertisement);
  }
}
