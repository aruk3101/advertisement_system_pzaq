package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AdvertisementRequirement entities.
 */
@RequiredArgsConstructor
public class DeleteAdvertisementRequirementUseCase {
  private final AdvertisementRequirementRepository advertisementRequirementRepository;

  public void delete(UUID uuid) {
    AdvertisementRequirement advertisementRequirement = advertisementRequirementRepository.get(uuid);
    advertisementRequirementRepository.delete(advertisementRequirement);
  }

}

