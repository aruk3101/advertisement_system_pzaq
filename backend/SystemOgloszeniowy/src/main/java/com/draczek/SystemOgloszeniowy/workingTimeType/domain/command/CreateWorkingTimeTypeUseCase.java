package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.command.PositionLevel;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.CreatePositionLevelDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.CreateWorkingTimeTypeDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.WorkingTimeTypeDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating WorkingTimeType.
 */

@RequiredArgsConstructor
public class CreateWorkingTimeTypeUseCase {
  private final SecurityFacade securityFacade;
  private final WorkingTimeTypeRepository workingTimeTypeRepository;
  private final WorkingTimeTypeMapper workingTimeTypeMapper;

  /**
   * Method for creating WorkingTimeTypes.
   *
   * @param dto CreateWorkingTimeTypeDto
   * @return WorkingTimeTypeDto dto
   */
  public WorkingTimeTypeDto createWorkingTimeTypeDto(CreateWorkingTimeTypeDto dto) {
    return workingTimeTypeMapper.toDto(createLanguageLevel(dto));
  }

  private WorkingTimeType createLanguageLevel(CreateWorkingTimeTypeDto dto) {
    WorkingTimeType workingTimeType = WorkingTimeType.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .build();
    workingTimeType.setStatus(StatusEnum.ACTIVE);
    workingTimeType.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    workingTimeType.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return workingTimeTypeRepository.saveAndFlush(workingTimeType);
  }
}
