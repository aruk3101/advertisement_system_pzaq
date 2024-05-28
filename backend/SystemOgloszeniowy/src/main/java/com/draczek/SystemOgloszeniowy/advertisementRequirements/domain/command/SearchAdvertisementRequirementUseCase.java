package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.AdvertisementRequirementDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching AdvertisementRequirement.
 */
@RequiredArgsConstructor
public class SearchAdvertisementRequirementUseCase {
  private final AdvertisementRequirementMapper advertisementRequirementMapper;
  private final AdvertisementRequirementRepository advertisementRequirementRepository;

  public List<AdvertisementRequirementDto> search() {
    return advertisementRequirementRepository.findAll().stream().map(advertisementRequirementMapper::toDto).toList();
  }

  public AdvertisementRequirement getEntity(UUID uuid) {
    return advertisementRequirementRepository.get(uuid);
  }
}
