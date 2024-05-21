package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.CreatePositionLevelDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Position Levels.
 */

@RequiredArgsConstructor
public class CreatePositionLevelUseCase {
  private final SecurityFacade securityFacade;
  private final PositionLevelRepository positionLevelRepository;
  private final PositionLevelMapper positionLevelMapper;

  /**
   * Method for creating Position Levels.
   *
   * @param dto CreatePositionLevelDto
   * @return PositionLevelDto dto
   */
  public PositionLevelDto createPositionLevelDto(CreatePositionLevelDto dto) {
    return positionLevelMapper.toDto(createLanguageLevel(dto));
  }

  private PositionLevel createLanguageLevel(CreatePositionLevelDto dto) {
    PositionLevel positionLevel = PositionLevel.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .build();
    positionLevel.setStatus(StatusEnum.ACTIVE);
    positionLevel.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    positionLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return positionLevelRepository.saveAndFlush(positionLevel);
  }
}
