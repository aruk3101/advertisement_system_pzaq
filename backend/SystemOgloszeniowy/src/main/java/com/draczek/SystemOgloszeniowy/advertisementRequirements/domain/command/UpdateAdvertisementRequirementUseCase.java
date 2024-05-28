package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.AdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.UpdateAdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating AdvertisementRequirement.
 */
@RequiredArgsConstructor
public class UpdateAdvertisementRequirementUseCase {
  private final AdvertisementRequirementRepository advertisementRequirementRepository;
  private final SecurityFacade securityFacade;
  private final AdvertisementRequirementMapper advertisementRequirementMapper;

  /**
   * Method for updating AdvertisementRequirement.
   *
   * @param uuid AdvertisementRequirement's UUID
   * @param dto  UpdateAdvertisementRequirementDto
   * @return modified AdvertisementRequirementDto
   */
  public AdvertisementRequirementDto updateDto(UUID uuid,
                                               UpdateAdvertisementRequirementDto dto) {
    return advertisementRequirementMapper.toDto(update(uuid, dto));
  }

  private AdvertisementRequirement update(UUID uuid, UpdateAdvertisementRequirementDto dto) {
    AdvertisementRequirement advertisementRequirement
        = advertisementRequirementRepository.get(uuid);
    advertisementRequirement.setName(dto.getName());
    advertisementRequirement.setVersion(dto.getVersion());
    advertisementRequirement.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementRequirementRepository.saveAndFlush(advertisementRequirement);
  }
}