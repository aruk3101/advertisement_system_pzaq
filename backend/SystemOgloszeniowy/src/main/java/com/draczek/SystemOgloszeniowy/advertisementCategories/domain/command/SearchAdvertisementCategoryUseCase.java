package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.AdvertisementCategoryDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching AdvertisementCategory.
 */
@RequiredArgsConstructor
public class SearchAdvertisementCategoryUseCase {
  private final AdvertisementCategoryMapper advertisementCategoryMapper;
  private final AdvertisementCategoryRepository advertisementCategoryRepository;

  public List<AdvertisementCategoryDto> search() {
    return advertisementCategoryRepository.findAll().stream().map(advertisementCategoryMapper::toDto).toList();
  }

  public AdvertisementCategory getEntity(UUID uuid) {
    return advertisementCategoryRepository.get(uuid);
  }
}
