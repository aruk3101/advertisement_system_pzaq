package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.CreateLanguageLevelDto;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.LanguageLevelDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Language Levels.
 */

@RequiredArgsConstructor
public class CreateLanguageLevelUseCase {
  private final SecurityFacade securityFacade;
  private final LanguageLevelRepository languageLevelRepository;
  private final LanguageLevelMapper languageLevelMapper;

  /**
   * Method for creating Language Levels.
   *
   * @param dto CreateLanguageLevelDto
   * @return LanguageLevelDto dto
   */
  public LanguageLevelDto createLanguageLevelDto(CreateLanguageLevelDto dto) {
    return languageLevelMapper.toDto(createLanguageLevel(dto));
  }

  private LanguageLevel createLanguageLevel(CreateLanguageLevelDto dto) {
    LanguageLevel languageLevel = LanguageLevel.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .build();
    languageLevel.setStatus(StatusEnum.ACTIVE);
    languageLevel.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    languageLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return languageLevelRepository.saveAndFlush(languageLevel);
  }
}

