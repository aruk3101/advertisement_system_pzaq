package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.AdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.CreateAdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating AdvertisementCategory.
 */

@RequiredArgsConstructor
public class CreateAdvertisementCategoryUseCase {
  private final SecurityFacade securityFacade;
  private final AdvertisementCategoryRepository advertisementCategoryRepository;
  private final AdvertisementCategoryMapper advertisementCategoryMapper;

  /**
   * Method for creating AdvertisementCategory.
   *
   * @param dto CreateAdvertisementCategoryDto
   * @return AdvertisementCategoryDto dto
   */
  public AdvertisementCategoryDto createAdvertisementCategoryDto(CreateAdvertisementCategoryDto dto) {
    return advertisementCategoryMapper.toDto(createLanguageLevel(dto));
  }

  private AdvertisementCategory createLanguageLevel(CreateAdvertisementCategoryDto dto) {
    AdvertisementCategory advertisementCategory = AdvertisementCategory.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .build();
    advertisementCategory.setStatus(StatusEnum.ACTIVE);
    advertisementCategory.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    advertisementCategory.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return advertisementCategoryRepository.saveAndFlush(advertisementCategory);
  }
}
