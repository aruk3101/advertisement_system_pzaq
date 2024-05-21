package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.UpdatePositionLevelDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Position levels.
 */
@RequiredArgsConstructor
public class UpdatePositionLevelUseCase {
  private final PositionLevelRepository positionLevelRepository;
  private final SecurityFacade securityFacade;
  private final PositionLevelMapper positionLevelMapper;

  /**
   * Method for updating PositionLevels.
   *
   * @param uuid PositionLevel's UUID
   * @param dto  UpdatePositionLevelDto
   * @return modified PositionLevelDto
   */
  public PositionLevelDto updateDto(UUID uuid, UpdatePositionLevelDto dto) {
    return positionLevelMapper.toDto(update(uuid, dto));
  }

  private PositionLevel update(UUID uuid, UpdatePositionLevelDto dto) {
    PositionLevel positionLevel = positionLevelRepository.get(uuid);
    positionLevel.setName(dto.getName());
    positionLevel.setVersion(dto.getVersion());
    positionLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return positionLevelRepository.saveAndFlush(positionLevel);
  }
}
