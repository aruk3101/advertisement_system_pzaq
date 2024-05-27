package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.AdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.CreateAdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.UpdateAdvertisementCategoryDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * AdvertisementCategory's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AdvertisementCategoryFacade {
  private final SearchAdvertisementCategoryUseCase searchAdvertisementCategoryUseCase;
  private final CreateAdvertisementCategoryUseCase createAdvertisementCategoryUseCase;
  private final DeleteAdvertisementCategoryUseCase deleteAdvertisementCategoryUseCase;
  private final UpdateAdvertisementCategoryUseCase updateAdvertisementCategoryUseCase;

  /**
   * Method for searching for all available AdvertisementCategory.
   *
   * @return list of AdvertisementCategoryDto
   */
  public List<AdvertisementCategoryDto> search() {
    return searchAdvertisementCategoryUseCase.search();
  }

  /**
   * Method for searching AdvertisementCategory entity by its UUID.
   *
   * @return AdvertisementCategory entity
   */
  public AdvertisementCategory getEntity(UUID uuid) {
    return searchAdvertisementCategoryUseCase.getEntity(uuid);
  }

  /**
   * Method for creating AdvertisementCategory.
   *
   * @param dto CreateAdvertisementCategoryDto
   * @return AdvertisementCategoryDto
   */
  public AdvertisementCategoryDto create(CreateAdvertisementCategoryDto dto) {
    return createAdvertisementCategoryUseCase.createAdvertisementCategoryDto(dto);
  }

  /**
   * Method for deleting AdvertisementCategory by its UUID.
   *
   * @param uuid AdvertisementCategory's UUID
   */
  public void delete(UUID uuid) {
    deleteAdvertisementCategoryUseCase.delete(uuid);
  }

  /**
   * Method for updating AdvertisementCategory entity by its UUID.
   *
   * @param uuid AdvertisementCategory's UUID
   * @param dto  UpdateAdvertisementCategoryDto
   * @return modified AdvertisementCategoryDto
   */
  public AdvertisementCategoryDto update(UUID uuid, UpdateAdvertisementCategoryDto dto) {
    return updateAdvertisementCategoryUseCase.updateDto(uuid, dto);
  }
}
