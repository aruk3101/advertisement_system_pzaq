package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.AdvertisementOpportunityDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching AdvertisementOpportunity.
 */
@RequiredArgsConstructor
public class SearchAdvertisementOpportunityUseCase {
  private final AdvertisementOpportunityMapper advertisementOpportunityMapper;
  private final AdvertisementOpportunityRepository advertisementOpportunityRepository;

  public List<AdvertisementOpportunityDto> search() {
    return advertisementOpportunityRepository.findAll().stream().map(advertisementOpportunityMapper::toDto).toList();
  }

  public AdvertisementOpportunity getEntity(UUID uuid) {
    return advertisementOpportunityRepository.get(uuid);
  }
}
