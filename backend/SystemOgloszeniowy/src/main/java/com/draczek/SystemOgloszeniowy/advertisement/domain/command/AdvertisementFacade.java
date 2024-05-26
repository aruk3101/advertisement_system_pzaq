package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.AdvertisementDto;
import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.CreateAdvertisementDto;
import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.UpdateAdvertisementDto;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

/**
 * Advertisement's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AdvertisementFacade {
  private final SearchAdvertisementUseCase searchAdvertisementUseCase;
  private final CreateAdvertisementUseCase createAdvertisementUseCase;
  private final DeleteAdvertisementUseCase deleteAdvertisementUseCase;
  private final UpdateAdvertisementUseCase updateAdvertisementUseCase;

  /**
   * Method for searching for all available Advertisement.
   *
   * @return Page of Advertisements
   */
  public Page<AdvertisementDto> search(Pageable pageable) {
    return searchAdvertisementUseCase.search(pageable);
  }

  /**
   * Method for searching Advertisement entity by its UUID.
   *
   * @return Advertisement entity
   */
  public Advertisement getEntity(UUID uuid) {
    return searchAdvertisementUseCase.getEntity(uuid);
  }

  /**
   * Method for searching Advertisement dto by its UUID.
   *
   * @return Advertisement dto
   */
  public AdvertisementDto get(UUID uuid) {
    return searchAdvertisementUseCase.get(uuid);
  }

  /**
   * Method for creating ContractType.
   *
   * @param dto CreateContractTypeDto
   * @return ContractTypeDto
   */
  public AdvertisementDto create(CreateAdvertisementDto dto) {
    return createAdvertisementUseCase.createAdvertisementDto(dto);
  }

  /**
   * Method for deleting Advertisement by its UUID.
   *
   * @param uuid Advertisement's UUID
   */
  public void delete(UUID uuid) {
    deleteAdvertisementUseCase.delete(uuid);
  }

  /**
   * Method for updating Advertisement entity by its UUID.
   *
   * @param uuid Advertisement's UUID
   * @param dto  UpdateAdvertisementDto
   * @return modified AdvertisementDto
   */
  public AdvertisementDto update(UUID uuid, UpdateAdvertisementDto dto) {
    return updateAdvertisementUseCase.updateDto(uuid, dto);
  }
}
