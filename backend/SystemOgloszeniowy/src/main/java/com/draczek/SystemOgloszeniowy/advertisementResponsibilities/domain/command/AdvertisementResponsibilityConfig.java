package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;


import com.draczek.SystemOgloszeniowy.advertisement.domain.command.AdvertisementFacade;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command.SearchAdvertisementCategoryUseCase;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AdvertisementResponsibilityFacade.
 */
@Configuration
public class AdvertisementResponsibilityConfig {
  @Bean
  AdvertisementResponsibilityFacade advertisementResponsibilityFacades(
      AdvertisementResponsibilityRepository advertisementResponsibilityRepository,
      SecurityFacade securityFacade,
      AdvertisementFacade advertisementFacade
  ) {
    AdvertisementResponsibilityMapper advertisementResponsibilityMapper = Mappers.getMapper(AdvertisementResponsibilityMapper.class);

    SearchAdvertisementResponsibilityUseCase advertisementCategoryUseCase = new SearchAdvertisementResponsibilityUseCase(
        advertisementResponsibilityMapper,
        advertisementResponsibilityRepository);

    CreateAdvertisementResponsibilityUseCase createAdvertisementResponsibilityUseCase = new CreateAdvertisementResponsibilityUseCase(
        securityFacade,
        advertisementResponsibilityRepository,
        advertisementResponsibilityMapper,
        advertisementFacade);

    DeleteAdvertisementResponsibilityUseCase deleteAdvertisementResponsibilityUseCase = new DeleteAdvertisementResponsibilityUseCase(
        advertisementResponsibilityRepository);

    UpdateAdvertisementResponsibilityUseCase updateAdvertisementResponsibilityUseCase = new UpdateAdvertisementResponsibilityUseCase(
        advertisementResponsibilityRepository,
        securityFacade,
        advertisementResponsibilityMapper);

    return new AdvertisementResponsibilityFacade(
        advertisementCategoryUseCase,
        createAdvertisementResponsibilityUseCase,
        deleteAdvertisementResponsibilityUseCase,
        updateAdvertisementResponsibilityUseCase);
  }
}
