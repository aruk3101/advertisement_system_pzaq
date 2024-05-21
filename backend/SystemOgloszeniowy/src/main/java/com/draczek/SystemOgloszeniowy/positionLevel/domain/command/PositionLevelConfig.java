package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for PositionLevelFacade.
 */
@Configuration
public class PositionLevelConfig {
  @Bean
  PositionLevelFacade positionLevelFacade(
      PositionLevelRepository positionLevelRepository,
      SecurityFacade securityFacade
  ) {
    PositionLevelMapper positionLevelMapper = Mappers.getMapper(PositionLevelMapper.class);

    SearchPositionLevelUseCase searchPositionLevelUseCase = new SearchPositionLevelUseCase(
        positionLevelMapper,
        positionLevelRepository);

    CreatePositionLevelUseCase createPositionLevelUseCase = new CreatePositionLevelUseCase(
        securityFacade,
        positionLevelRepository,
        positionLevelMapper);

    DeletePositionLevelUseCase deletePositionLevelUseCase = new DeletePositionLevelUseCase(
        positionLevelRepository);

    UpdatePositionLevelUseCase updatePositionLevelUseCase = new UpdatePositionLevelUseCase(
        positionLevelRepository,
        securityFacade,
        positionLevelMapper);

    return new PositionLevelFacade(
        searchPositionLevelUseCase,
        createPositionLevelUseCase,
        deletePositionLevelUseCase,
        updatePositionLevelUseCase);
  }
}
