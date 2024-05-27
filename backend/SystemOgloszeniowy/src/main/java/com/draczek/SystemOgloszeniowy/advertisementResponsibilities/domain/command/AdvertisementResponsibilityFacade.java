package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.AdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.CreateAdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.UpdateAdvertisementResponsibilityDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * AdvertisementResponsibility's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AdvertisementResponsibilityFacade {
  private final SearchAdvertisementResponsibilityUseCase searchAdvertisementResponsibilityUseCase;
  private final CreateAdvertisementResponsibilityUseCase createAdvertisementResponsibilityUseCase;
  private final DeleteAdvertisementResponsibilityUseCase deleteAdvertisementResponsibilityUseCase;
  private final UpdateAdvertisementResponsibilityUseCase updateAdvertisementResponsibilityUseCase;

  /**
   * Method for searching for all available AdvertisementResponsibility.
   *
   * @return list of AdvertisementResponsibility
   */
  public List<AdvertisementResponsibilityDto> search() {
    return searchAdvertisementResponsibilityUseCase.search();
  }

  /**
   * Method for searching AdvertisementResponsibility entity by its UUID.
   *
   * @return AdvertisementResponsibility entity
   */
  public AdvertisementResponsibility getEntity(UUID uuid) {
    return searchAdvertisementResponsibilityUseCase.getEntity(uuid);
  }

  /**
   * Method for creating AdvertisementResponsibility.
   *
   * @param dto CreateAdvertisementResponsibilityDto
   * @return AdvertisementResponsibilityDto
   */
  public AdvertisementResponsibilityDto create(CreateAdvertisementResponsibilityDto dto) {
    return createAdvertisementResponsibilityUseCase.createAdvertisementResponsibilityDto(dto);
  }

  /**
   * Method for deleting AdvertisementResponsibility by its UUID.
   *
   * @param uuid AdvertisementResponsibility's UUID
   */
  public void delete(UUID uuid) {
    deleteAdvertisementResponsibilityUseCase.delete(uuid);
  }

  /**
   * Method for updating AdvertisementResponsibility entity by its UUID.
   *
   * @param uuid AdvertisementResponsibility's UUID
   * @param dto  UpdateAdvertisementResponsibilityDto
   * @return modified AdvertisementResponsibilityDto
   */
  public AdvertisementResponsibilityDto update(UUID uuid, UpdateAdvertisementResponsibilityDto dto) {
    return updateAdvertisementResponsibilityUseCase.updateDto(uuid, dto);
  }
}
