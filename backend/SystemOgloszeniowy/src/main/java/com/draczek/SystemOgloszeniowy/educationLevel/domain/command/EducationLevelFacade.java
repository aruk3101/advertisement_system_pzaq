package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.CreateEducationLevelDto;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.EducationLevelDto;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.UpdateEducationLevelDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Education Level's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class EducationLevelFacade {
  private final SearchEducationLevelUseCase searchEducationLevelUseCase;
  private final CreateEducationLevelUseCase createEducationLevelUseCase;
  private final DeleteEducationLevelUseCase deleteEducationLevelUseCase;
  private final UpdateEducationLevelUseCase updateEducationLevelUseCase;

  /**
   * Method for searching for all available EducationLevels.
   *
   * @return list of EducationLevels
   */
  public List<EducationLevelDto> search() {
    return searchEducationLevelUseCase.search();
  }

  /**
   * Method for searching EducationLevel entity by its UUID.
   *
   * @param uuid EducationLevel's UUID
   * @return EducationLevel entity
   */
  public EducationLevel getEntity(UUID uuid) {
    return searchEducationLevelUseCase.search(uuid);
  }

  /**
   * Method for creating Education levels.
   *
   * @param dto CreateEducationLevelDto
   * @return EducationLevelDto
   */
  public EducationLevelDto create(CreateEducationLevelDto dto) {
    return createEducationLevelUseCase.createEducationLevelDto(dto);
  }

  /**
   * Method for deleting Education level by its UUID.
   *
   * @param uuid EducationLevel's UUID
   */
  public void delete(UUID uuid) {
    deleteEducationLevelUseCase.delete(uuid);
  }

  /**
   * Method for updating EducationLevel entity by its UUID.
   *
   * @param uuid EducationLevel's UUID
   * @param dto UpdateEducationLevelDto
   * @return modified EducationLevelDto
   */
  public EducationLevelDto update(UUID uuid, UpdateEducationLevelDto dto) {
    return updateEducationLevelUseCase.updateDto(uuid, dto);
  }
}
