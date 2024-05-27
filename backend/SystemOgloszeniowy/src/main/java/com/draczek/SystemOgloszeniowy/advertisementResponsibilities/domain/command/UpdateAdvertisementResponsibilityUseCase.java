package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.AdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.UpdateAdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating AdvertisementResponsibility.
 */
@RequiredArgsConstructor
public class UpdateAdvertisementResponsibilityUseCase {
  private final AdvertisementResponsibilityRepository advertisementResponsibilityRepository;
  private final SecurityFacade securityFacade;
  private final AdvertisementResponsibilityMapper advertisementResponsibilityMapper;

  /**
   * Method for updating AdvertisementResponsibility.
   *
   * @param uuid AdvertisementResponsibility's UUID
   * @param dto  UpdateAdvertisementResponsibilityDto
   * @return modified AdvertisementResponsibilityDto
   */
  public AdvertisementResponsibilityDto updateDto(UUID uuid,
                                                  UpdateAdvertisementResponsibilityDto dto) {
    return advertisementResponsibilityMapper.toDto(update(uuid, dto));
  }

  private AdvertisementResponsibility update(UUID uuid, UpdateAdvertisementResponsibilityDto dto) {
    AdvertisementResponsibility advertisementResponsibility
        = advertisementResponsibilityRepository.get(uuid);
    advertisementResponsibility.setName(dto.getName());
    advertisementResponsibility.setVersion(dto.getVersion());
    advertisementResponsibility.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementResponsibilityRepository.saveAndFlush(advertisementResponsibility);
  }
}
