package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting Advertisement entities.
 */
@RequiredArgsConstructor
public class DeleteAdvertisementUseCase {
  private final AdvertisementRepository advertisementRepository;

  public void delete(UUID uuid) {
    Advertisement positionLevel = advertisementRepository.get(uuid);
    advertisementRepository.delete(positionLevel);
  }

}
