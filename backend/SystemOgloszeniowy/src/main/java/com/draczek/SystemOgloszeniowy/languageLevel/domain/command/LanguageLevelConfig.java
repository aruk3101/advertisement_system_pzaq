package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for LanguageLevelFacade.
 */
@Configuration
public class LanguageLevelConfig {
  @Bean
  LanguageLevelFacade languageLevelFacade(
      LanguageLevelRepository languageLevelRepository,
      SecurityFacade securityFacade
  ) {
    LanguageLevelMapper languageLevelMapper = Mappers.getMapper(LanguageLevelMapper.class);

    SearchLanguageLevelUseCase searchLanguageLevelUseCase = new SearchLanguageLevelUseCase(
        languageLevelMapper,
        languageLevelRepository);

    CreateLanguageLevelUseCase createLanguageLevelUseCase = new CreateLanguageLevelUseCase(
        securityFacade,
        languageLevelRepository,
        languageLevelMapper);

    DeleteLanguageLevelUseCase deleteLanguageLevelUseCase = new DeleteLanguageLevelUseCase(
        languageLevelRepository);

    UpdateLanguageLevelUseCase updateLanguageLevelUseCase = new UpdateLanguageLevelUseCase(
        languageLevelRepository,
        securityFacade,
        languageLevelMapper);

    return new LanguageLevelFacade(
        searchLanguageLevelUseCase,
        createLanguageLevelUseCase,
        deleteLanguageLevelUseCase,
        updateLanguageLevelUseCase);
  }
}
