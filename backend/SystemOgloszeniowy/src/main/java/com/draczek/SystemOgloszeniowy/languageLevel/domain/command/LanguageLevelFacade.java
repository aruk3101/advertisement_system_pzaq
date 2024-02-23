package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.CreateLanguageLevelDto;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.LanguageLevelDto;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.UpdateLanguageLevelDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Language Level's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class LanguageLevelFacade {
  private final SearchLanguageLevelUseCase searchLanguageLevelUseCase;
  private final CreateLanguageLevelUseCase createLanguageLevelUseCase;
  private final DeleteLanguageLevelUseCase deleteLanguageLevelUseCase;
  private final UpdateLanguageLevelUseCase updateLanguageLevelUseCase;

  /**
   * Method for searching for all available LanguageLevels.
   *
   * @return list of LanguageLevels
   */
  public List<LanguageLevelDto> search() {
    return searchLanguageLevelUseCase.search();
  }

  /**
   * Method for searching LanguageLevel entity by its UUID.
   *
   * @return LanguageLevel entity
   */
  public LanguageLevel getEntity(UUID uuid) {
    return searchLanguageLevelUseCase.getEntity(uuid);
  }

  /**
   * Method for creating Language levels.
   *
   * @param dto CreateLanguageLevelDto
   * @return LanguageLevelDto
   */
  public LanguageLevelDto create(CreateLanguageLevelDto dto) {
    return createLanguageLevelUseCase.createLanguageLevelDto(dto);
  }

  /**
   * Method for deleting Language level by its UUID.
   *
   * @param uuid LanguageLevel's UUID
   */
  public void delete(UUID uuid) {
    deleteLanguageLevelUseCase.delete(uuid);
  }

  /**
   * Method for updating LanguageLevel entity by its UUID.
   *
   * @param uuid LanguageLevel's UUID
   * @param dto  UpdateLanguageLevelDto
   * @return modified LanguageLevelDto
   */
  public LanguageLevelDto update(UUID uuid, UpdateLanguageLevelDto dto) {
    return updateLanguageLevelUseCase.updateDto(uuid, dto);
  }
}
