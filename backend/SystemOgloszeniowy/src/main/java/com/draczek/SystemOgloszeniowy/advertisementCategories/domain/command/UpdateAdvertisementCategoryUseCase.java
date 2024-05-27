package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.AdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.UpdateAdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating AdvertisementCategory.
 */
@RequiredArgsConstructor
public class UpdateAdvertisementCategoryUseCase {
  private final AdvertisementCategoryRepository advertisementCategoryRepository;
  private final SecurityFacade securityFacade;
  private final AdvertisementCategoryMapper advertisementCategoryMapper;

  /**
   * Method for updating AdvertisementCategory.
   *
   * @param uuid AdvertisementCategory's UUID
   * @param dto  UpdateAdvertisementCategoryDto
   * @return modified AdvertisementCategoryDto
   */
  public AdvertisementCategoryDto updateDto(UUID uuid, UpdateAdvertisementCategoryDto dto) {
    return advertisementCategoryMapper.toDto(update(uuid, dto));
  }

  private AdvertisementCategory update(UUID uuid, UpdateAdvertisementCategoryDto dto) {
    AdvertisementCategory advertisementCategory = advertisementCategoryRepository.get(uuid);
    advertisementCategory.setName(dto.getName());
    advertisementCategory.setVersion(dto.getVersion());
    advertisementCategory.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementCategoryRepository.saveAndFlush(advertisementCategory);
  }
}
