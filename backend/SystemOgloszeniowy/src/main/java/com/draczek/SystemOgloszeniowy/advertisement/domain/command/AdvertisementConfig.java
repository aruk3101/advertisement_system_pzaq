package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import com.draczek.SystemOgloszeniowy.company.domain.command.CompanyFacade;
import com.draczek.SystemOgloszeniowy.contractType.domain.command.ContractTypeFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.jobType.domain.command.JobTypeFacade;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.command.PositionLevelFacade;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.command.WorkingTimeTypeFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AdvertisementFacade.
 */
@Configuration
public class AdvertisementConfig {
  @Bean
  AdvertisementFacade advertisementFacade(
      AdvertisementRepository advertisementRepository,
      SecurityFacade securityFacade,
      CompanyFacade companyFacade,
      PositionLevelFacade positionLevelFacade,
      ContractTypeFacade contractTypeFacade,
      WorkingTimeTypeFacade workingTimeTypeFacade,
      JobTypeFacade jobTypeFacade
  ) {
    AdvertisementMapper advertisementMapper = Mappers.getMapper(AdvertisementMapper.class);

    SearchAdvertisementUseCase searchAdvertisementUseCase = new SearchAdvertisementUseCase(
        advertisementMapper,
        advertisementRepository);

    CreateAdvertisementUseCase createAdvertisementUseCase = new CreateAdvertisementUseCase(
        securityFacade,
        advertisementRepository,
        advertisementMapper,
        companyFacade,
        positionLevelFacade,
        contractTypeFacade,
        workingTimeTypeFacade,
        jobTypeFacade);

    DeleteAdvertisementUseCase deleteAdvertisementUseCase = new DeleteAdvertisementUseCase(
        advertisementRepository);

    UpdateAdvertisementUseCase updateAdvertisementUseCase = new UpdateAdvertisementUseCase(
        advertisementRepository,
        securityFacade,
        advertisementMapper,
        positionLevelFacade,
        contractTypeFacade,
        workingTimeTypeFacade,
        jobTypeFacade);

    return new AdvertisementFacade(
        searchAdvertisementUseCase,
        createAdvertisementUseCase,
        deleteAdvertisementUseCase,
        updateAdvertisementUseCase);
  }
}
