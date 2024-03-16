package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.CreateEducationLevelDto;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.EducationLevelDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Education Levels.
 */

@RequiredArgsConstructor
public class CreateEducationLevelUseCase {
  private final SecurityFacade securityFacade;
  private final EducationLevelRepository educationLevelRepository;
  private final EducationLevelMapper educationLevelMapper;

  /**
   * Method for creating Education Levels.
   *
   * @param dto CreateEducationLevelDto
   * @return EducationLevel dto
   */
  public EducationLevelDto createEducationLevelDto(CreateEducationLevelDto dto) {
    return educationLevelMapper.toDto(createEducationLevel(dto));
  }

  private EducationLevel createEducationLevel(CreateEducationLevelDto dto) {
    EducationLevel educationLevel = EducationLevel.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .build();
    educationLevel.setStatus(StatusEnum.ACTIVE);
    educationLevel.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    educationLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return educationLevelRepository.saveAndFlush(educationLevel);

  }
}
