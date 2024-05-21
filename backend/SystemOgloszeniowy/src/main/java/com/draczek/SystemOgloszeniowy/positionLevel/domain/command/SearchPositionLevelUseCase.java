package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching Position Levels.
 */
@RequiredArgsConstructor
public class SearchPositionLevelUseCase {
  private final PositionLevelMapper positionLevelMapper;
  private final PositionLevelRepository positionLevelRepository;

  public List<PositionLevelDto> search() {
    return positionLevelRepository.findAll().stream().map(positionLevelMapper::toDto).toList();
  }

  public PositionLevel getEntity(UUID uuid) {
    return  positionLevelRepository.get(uuid);
  }
}
