package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.CreateAdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AdvertisementCategoryFacade.
 */
@Configuration
public class AdvertisementCategoryConfig {
  @Bean
  AdvertisementCategoryFacade advertisementCategoryFacade(
      AdvertisementCategoryRepository advertisementCategoryRepository,
      SecurityFacade securityFacade
  ) {
    AdvertisementCategoryMapper advertisementCategoryMapper = Mappers.getMapper(AdvertisementCategoryMapper.class);

    SearchAdvertisementCategoryUseCase searchAdvertisementCategoryUseCase = new SearchAdvertisementCategoryUseCase(
        advertisementCategoryMapper,
        advertisementCategoryRepository);

    CreateAdvertisementCategoryUseCase createAdvertisementCategoryUseCase = new CreateAdvertisementCategoryUseCase(
        securityFacade,
        advertisementCategoryRepository,
        advertisementCategoryMapper);

    DeleteAdvertisementCategoryUseCase deleteAdvertisementCategoryUseCase = new DeleteAdvertisementCategoryUseCase(
        advertisementCategoryRepository);

    UpdateAdvertisementCategoryUseCase updateAdvertisementCategoryUseCase = new UpdateAdvertisementCategoryUseCase(
        advertisementCategoryRepository,
        securityFacade,
        advertisementCategoryMapper);

    return new AdvertisementCategoryFacade(
        searchAdvertisementCategoryUseCase,
        createAdvertisementCategoryUseCase,
        deleteAdvertisementCategoryUseCase,
        updateAdvertisementCategoryUseCase);
  }
}
