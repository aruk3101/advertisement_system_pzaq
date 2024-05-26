package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.AdvertisementDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Class for searching Advertisement.
 */
@RequiredArgsConstructor
public class SearchAdvertisementUseCase {
  private final AdvertisementMapper advertisementMapper;
  private final AdvertisementRepository advertisementRepository;

  public Page<AdvertisementDto> search(Pageable pageable) {
    return advertisementRepository.findAll(pageable).map(advertisementMapper::toDto);
  }

  public AdvertisementDto get(UUID uuid) {
    return advertisementMapper.toDto(getEntity(uuid));
  }

  public Advertisement getEntity(UUID uuid) {
    return advertisementRepository.get(uuid);
  }
}
