package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.command.AdvertisementFacade;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.AdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.CreateAdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating AdvertisementResponsibility.
 */

@RequiredArgsConstructor
public class CreateAdvertisementResponsibilityUseCase {
  private final SecurityFacade securityFacade;
  private final AdvertisementResponsibilityRepository advertisementResponsibilityRepository;
  private final AdvertisementResponsibilityMapper advertisementResponsibilityMapper;
  private final AdvertisementFacade advertisementFacade;

  /**
   * Method for creating AdvertisementResponsibility.
   *
   * @param dto CreateAdvertisementResponsibilityDto
   * @return AdvertisementResponsibilityDto dto
   */
  public AdvertisementResponsibilityDto createAdvertisementResponsibilityDto(CreateAdvertisementResponsibilityDto dto) {
    return advertisementResponsibilityMapper.toDto(createLanguageLevel(dto));
  }

  private AdvertisementResponsibility createLanguageLevel(CreateAdvertisementResponsibilityDto dto) {
    AdvertisementResponsibility advertisementResponsibility = AdvertisementResponsibility.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .advertisement(advertisementFacade.getEntity(dto.getAdvertisementUuid()))
        .build();
    advertisementResponsibility.setStatus(StatusEnum.ACTIVE);
    advertisementResponsibility.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    advertisementResponsibility.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementResponsibilityRepository.saveAndFlush(advertisementResponsibility);
  }
}
