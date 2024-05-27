package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.AdvertisementResponsibilityDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching AdvertisementResponsibility.
 */
@RequiredArgsConstructor
public class SearchAdvertisementResponsibilityUseCase {
  private final AdvertisementResponsibilityMapper advertisementResponsibilityMapper;
  private final AdvertisementResponsibilityRepository advertisementResponsibilityRepository;

  public List<AdvertisementResponsibilityDto> search() {
    return advertisementResponsibilityRepository.findAll().stream().map(advertisementResponsibilityMapper::toDto).toList();
  }

  public AdvertisementResponsibility getEntity(UUID uuid) {
    return advertisementResponsibilityRepository.get(uuid);
  }
}
