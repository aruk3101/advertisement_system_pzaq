package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.AdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.CreateAdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.UpdateAdvertisementRequirementDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * AdvertisementRequirement's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AdvertisementRequirementFacade {
  private final SearchAdvertisementRequirementUseCase searchAdvertisementRequirementUseCase;
  private final CreateAdvertisementRequirementUseCase createAdvertisementRequirementUseCase;
  private final DeleteAdvertisementRequirementUseCase deleteAdvertisementRequirementUseCase;
  private final UpdateAdvertisementRequirementUseCase updateAdvertisementRequirementUseCase;

  /**
   * Method for searching for all available AdvertisementRequirement.
   *
   * @return list of AdvertisementRequirement
   */
  public List<AdvertisementRequirementDto> search() {
    return searchAdvertisementRequirementUseCase.search();
  }

  /**
   * Method for searching AdvertisementRequirement entity by its UUID.
   *
   * @return AdvertisementRequirement entity
   */
  public AdvertisementRequirement getEntity(UUID uuid) {
    return searchAdvertisementRequirementUseCase.getEntity(uuid);
  }

  /**
   * Method for creating AdvertisementRequirement.
   *
   * @param dto CreateAdvertisementRequirementDto
   * @return AdvertisementRequirementDto
   */
  public AdvertisementRequirementDto create(CreateAdvertisementRequirementDto dto) {
    return createAdvertisementRequirementUseCase.createAdvertisementRequirementDto(dto);
  }

  /**
   * Method for deleting AdvertisementRequirement by its UUID.
   *
   * @param uuid AdvertisementRequirement's UUID
   */
  public void delete(UUID uuid) {
    deleteAdvertisementRequirementUseCase.delete(uuid);
  }

  /**
   * Method for updating AdvertisementRequirement entity by its UUID.
   *
   * @param uuid AdvertisementRequirement's UUID
   * @param dto  UpdateAdvertisementRequirementDto
   * @return modified AdvertisementRequirementDto
   */
  public AdvertisementRequirementDto update(UUID uuid, UpdateAdvertisementRequirementDto dto) {
    return updateAdvertisementRequirementUseCase.updateDto(uuid, dto);
  }
}
