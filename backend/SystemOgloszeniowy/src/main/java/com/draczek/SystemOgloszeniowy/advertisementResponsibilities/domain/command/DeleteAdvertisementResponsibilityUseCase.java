package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AdvertisementResponsibility entities.
 */
@RequiredArgsConstructor
public class DeleteAdvertisementResponsibilityUseCase {
  private final AdvertisementResponsibilityRepository advertisementResponsibilityRepository;

  public void delete(UUID uuid) {
    AdvertisementResponsibility advertisementResponsibility = advertisementResponsibilityRepository.get(uuid);
    advertisementResponsibilityRepository.delete(advertisementResponsibility);
  }

}
