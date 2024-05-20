package com.draczek.SystemOgloszeniowy.company.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.command.AddressFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for CompanyFacade.
 */
@Configuration
class CompanyConfig {

  @Bean
  CompanyFacade companyFacade(
      CompanyRepository companyRepository,
      AddressFacade addressFacade
  ) {
    CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
    SearchCompaniesUseCase searchCompaniesUseCase = new SearchCompaniesUseCase(
        companyRepository,
        mapper
    );
    CreateCompanyUseCase createCompanyUseCase = new CreateCompanyUseCase(
        companyRepository,
        mapper
    );
    UpdateCompanyUseCase updateCompanyUseCase = new UpdateCompanyUseCase(
        companyRepository,
        mapper,
        addressFacade
    );
    DeleteCompanyUseCase deleteCompanyUseCase = new DeleteCompanyUseCase(companyRepository);
    return new CompanyFacade(
        searchCompaniesUseCase,
        createCompanyUseCase,
        updateCompanyUseCase,
        deleteCompanyUseCase
    );
  }
}
