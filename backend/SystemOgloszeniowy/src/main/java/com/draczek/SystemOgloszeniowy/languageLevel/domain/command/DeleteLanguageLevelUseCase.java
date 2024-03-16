package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting LanguageLevels entities.
 */
@RequiredArgsConstructor
public class DeleteLanguageLevelUseCase {
  private final LanguageLevelRepository languageLevelRepository;

  public void delete(UUID uuid) {
    LanguageLevel languageLevel = languageLevelRepository.get(uuid);
    languageLevelRepository.delete(languageLevel);
  }

}

