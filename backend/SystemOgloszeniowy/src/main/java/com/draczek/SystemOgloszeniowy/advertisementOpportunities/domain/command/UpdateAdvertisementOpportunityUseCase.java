package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.AdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.UpdateAdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating AdvertisementOpportunity.
 */
@RequiredArgsConstructor
public class UpdateAdvertisementOpportunityUseCase {
  private final AdvertisementOpportunityRepository advertisementOpportunityRepository;
  private final SecurityFacade securityFacade;
  private final AdvertisementOpportunityMapper advertisementOpportunityMapper;

  /**
   * Method for updating AdvertisementOpportunity.
   *
   * @param uuid AdvertisementOpportunity's UUID
   * @param dto  UpdateAdvertisementOpportunityDto
   * @return modified AdvertisementOpportunityDto
   */
  public AdvertisementOpportunityDto updateDto(UUID uuid,
                                               UpdateAdvertisementOpportunityDto dto) {
    return advertisementOpportunityMapper.toDto(update(uuid, dto));
  }

  private AdvertisementOpportunity update(UUID uuid, UpdateAdvertisementOpportunityDto dto) {
    AdvertisementOpportunity advertisementOpportunity
        = advertisementOpportunityRepository.get(uuid);
    advertisementOpportunity.setName(dto.getName());
    advertisementOpportunity.setVersion(dto.getVersion());
    advertisementOpportunity.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementOpportunityRepository.saveAndFlush(advertisementOpportunity);
  }
}
