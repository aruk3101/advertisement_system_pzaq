package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.AdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.CreateAdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.UpdateAdvertisementOpportunityDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * AdvertisementOpportunity's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AdvertisementOpportunityFacade {
  private final SearchAdvertisementOpportunityUseCase searchAdvertisementOpportunityUseCase;
  private final CreateAdvertisementOpportunityUseCase createAdvertisementOpportunityUseCase;
  private final DeleteAdvertisementOpportunityUseCase deleteAdvertisementOpportunityUseCase;
  private final UpdateAdvertisementOpportunityUseCase updateAdvertisementOpportunityUseCase;

  /**
   * Method for searching for all available AdvertisementOpportunity.
   *
   * @return list of AdvertisementOpportunity
   */
  public List<AdvertisementOpportunityDto> search() {
    return searchAdvertisementOpportunityUseCase.search();
  }

  /**
   * Method for searching AdvertisementOpportunity entity by its UUID.
   *
   * @return AdvertisementOpportunity entity
   */
  public AdvertisementOpportunity getEntity(UUID uuid) {
    return searchAdvertisementOpportunityUseCase.getEntity(uuid);
  }

  /**
   * Method for creating AdvertisementOpportunity.
   *
   * @param dto CreateAdvertisementOpportunityDto
   * @return AdvertisementOpportunityDto
   */
  public AdvertisementOpportunityDto create(CreateAdvertisementOpportunityDto dto) {
    return createAdvertisementOpportunityUseCase.createAdvertisementOpportunityDto(dto);
  }

  /**
   * Method for deleting AdvertisementOpportunity by its UUID.
   *
   * @param uuid AdvertisementOpportunity's UUID
   */
  public void delete(UUID uuid) {
    deleteAdvertisementOpportunityUseCase.delete(uuid);
  }

  /**
   * Method for updating AdvertisementOpportunity entity by its UUID.
   *
   * @param uuid AdvertisementOpportunity's UUID
   * @param dto  UpdateAdvertisementOpportunityDto
   * @return modified AdvertisementOpportunityDto
   */
  public AdvertisementOpportunityDto update(UUID uuid, UpdateAdvertisementOpportunityDto dto) {
    return updateAdvertisementOpportunityUseCase.updateDto(uuid, dto);
  }
}
