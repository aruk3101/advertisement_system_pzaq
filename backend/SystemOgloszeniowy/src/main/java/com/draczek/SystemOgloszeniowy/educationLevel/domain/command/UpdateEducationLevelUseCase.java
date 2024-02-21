package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.EducationLevelDto;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.UpdateEducationLevelDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Education levels.
 */
@RequiredArgsConstructor
public class UpdateEducationLevelUseCase {
  private final EducationLevelRepository educationLevelRepository;
  private final SecurityFacade securityFacade;
  private final EducationLevelMapper educationLevelMapper;

  /**
   * Method for updating EducationLevel.
   *
   * @param uuid EducationLevel's UUID
   * @param dto UpdateEducationLevelDto
   * @return modified EducationLevelDto
   */
  public EducationLevelDto updateDto(UUID uuid, UpdateEducationLevelDto dto) {
    return educationLevelMapper.toDto(update(uuid, dto));
  }

  private EducationLevel update(UUID uuid, UpdateEducationLevelDto dto) {
    EducationLevel educationLevel = educationLevelRepository.get(uuid);
    educationLevel.setName(dto.getName());
    educationLevel.setVersion(dto.getVersion());
    educationLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return educationLevelRepository.saveAndFlush(educationLevel);
  }
}
