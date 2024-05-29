package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AdvertisementOpportunity entities.
 */
@RequiredArgsConstructor
public class DeleteAdvertisementOpportunityUseCase {
  private final AdvertisementOpportunityRepository advertisementOpportunityRepository;

  public void delete(UUID uuid) {
    AdvertisementOpportunity advertisementOpportunity = advertisementOpportunityRepository.get(uuid);
    advertisementOpportunityRepository.delete(advertisementOpportunity);
  }

}
