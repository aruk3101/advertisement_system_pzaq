package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.LanguageLevelDto;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.UpdateLanguageLevelDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Language levels.
 */
@RequiredArgsConstructor
public class UpdateLanguageLevelUseCase {
  private final LanguageLevelRepository languageLevelRepository;
  private final SecurityFacade securityFacade;
  private final LanguageLevelMapper languageLevelMapper;

  /**
   * Method for updating LanguageLevels.
   *
   * @param uuid LanguageLevel's UUID
   * @param dto UpdateLanguageLevelDto
   * @return modified LanguageLevelDto
   */
  public LanguageLevelDto updateDto(UUID uuid, UpdateLanguageLevelDto dto) {
    return languageLevelMapper.toDto(update(uuid, dto));
  }

  private LanguageLevel update(UUID uuid, UpdateLanguageLevelDto dto) {
    LanguageLevel languageLevel = languageLevelRepository.get(uuid);
    languageLevel.setName(dto.getName());
    languageLevel.setVersion(dto.getVersion());
    languageLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return languageLevelRepository.saveAndFlush(languageLevel);
  }
}

