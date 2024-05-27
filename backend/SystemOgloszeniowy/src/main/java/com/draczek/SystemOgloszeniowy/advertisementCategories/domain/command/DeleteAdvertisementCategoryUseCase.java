package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AdvertisementCategory entities.
 */
@RequiredArgsConstructor
public class DeleteAdvertisementCategoryUseCase {
  private final AdvertisementCategoryRepository advertisementCategoryRepository;

  public void delete(UUID uuid) {
    AdvertisementCategory advertisementCategory = advertisementCategoryRepository.get(uuid);
    advertisementCategoryRepository.delete(advertisementCategory);
  }

}
