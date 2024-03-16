package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.LanguageLevelDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching Language Levels.
 */
@RequiredArgsConstructor
public class SearchLanguageLevelUseCase {
  private final LanguageLevelMapper languageLevelMapper;
  private final LanguageLevelRepository languageLevelRepository;

  public List<LanguageLevelDto> search() {
    return languageLevelRepository.findAll().stream().map(languageLevelMapper::toDto).toList();
  }

  public LanguageLevel getEntity(UUID uuid) {
    return  languageLevelRepository.get(uuid);
  }
}

