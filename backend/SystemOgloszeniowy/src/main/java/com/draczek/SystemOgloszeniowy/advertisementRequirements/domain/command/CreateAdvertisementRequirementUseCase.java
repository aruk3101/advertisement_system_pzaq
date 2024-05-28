package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.command.AdvertisementFacade;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.AdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.CreateAdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating AdvertisementRequirement.
 */

@RequiredArgsConstructor
public class CreateAdvertisementRequirementUseCase {
  private final SecurityFacade securityFacade;
  private final AdvertisementRequirementRepository advertisementRequirementRepository;
  private final AdvertisementRequirementMapper advertisementRequirementMapper;
  private final AdvertisementFacade advertisementFacade;

  /**
   * Method for creating AdvertisementRequirement.
   *
   * @param dto CreateAdvertisementRequirementDto
   * @return AdvertisementRequirementDto dto
   */
  public AdvertisementRequirementDto createAdvertisementRequirementDto(CreateAdvertisementRequirementDto dto) {
    return advertisementRequirementMapper.toDto(createLanguageLevel(dto));
  }

  private AdvertisementRequirement createLanguageLevel(CreateAdvertisementRequirementDto dto) {
    AdvertisementRequirement advertisementResponsibility = AdvertisementRequirement.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .advertisement(advertisementFacade.getEntity(dto.getAdvertisementUuid()))
        .build();
    advertisementResponsibility.setStatus(StatusEnum.ACTIVE);
    advertisementResponsibility.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    advertisementResponsibility.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementRequirementRepository.saveAndFlush(advertisementResponsibility);
  }
}
