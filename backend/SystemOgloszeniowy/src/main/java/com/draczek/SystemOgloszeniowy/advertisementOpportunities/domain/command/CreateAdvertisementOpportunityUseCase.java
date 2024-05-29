package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.command.AdvertisementFacade;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.AdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.CreateAdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating AdvertisementOpportunity.
 */

@RequiredArgsConstructor
public class CreateAdvertisementOpportunityUseCase {
  private final SecurityFacade securityFacade;
  private final AdvertisementOpportunityRepository advertisementOpportunityRepository;
  private final AdvertisementOpportunityMapper advertisementOpportunityMapper;
  private final AdvertisementFacade advertisementFacade;

  /**
   * Method for creating AdvertisementOpportunity.
   *
   * @param dto CreateAdvertisementOpportunityDto
   * @return AdvertisementOpportunityDto dto
   */
  public AdvertisementOpportunityDto createAdvertisementOpportunityDto(CreateAdvertisementOpportunityDto dto) {
    return advertisementOpportunityMapper.toDto(createLanguageLevel(dto));
  }

  private AdvertisementOpportunity createLanguageLevel(CreateAdvertisementOpportunityDto dto) {
    AdvertisementOpportunity advertisementOpportunity = AdvertisementOpportunity.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .advertisement(advertisementFacade.getEntity(dto.getAdvertisementUuid()))
        .build();
    advertisementOpportunity.setStatus(StatusEnum.ACTIVE);
    advertisementOpportunity.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    advertisementOpportunity.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementOpportunityRepository.saveAndFlush(advertisementOpportunity);
  }
}
