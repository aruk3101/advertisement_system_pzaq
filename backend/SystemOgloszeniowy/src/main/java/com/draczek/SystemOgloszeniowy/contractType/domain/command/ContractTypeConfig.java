package com.draczek.SystemOgloszeniowy.contractType.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for ContractTypeFacade.
 */
@Configuration
public class ContractTypeConfig {
  @Bean
  ContractTypeFacade contractTypeFacade(
      ContractTypeRepository contractTypeRepository,
      SecurityFacade securityFacade
  ) {
    ContractTypeMapper contractTypeMapper = Mappers.getMapper(ContractTypeMapper.class);

    SearchContractTypeUseCase searchContractTypeUseCase = new SearchContractTypeUseCase(
        contractTypeMapper,
        contractTypeRepository);

    CreateContractTypeUseCase createContractTypeUseCase = new CreateContractTypeUseCase(
        securityFacade,
        contractTypeRepository,
        contractTypeMapper);

    DeleteContractTypeUseCase deleteContractTypeUseCase = new DeleteContractTypeUseCase(
        contractTypeRepository);

    UpdateContractTypeUseCase updateContractTypeUseCase = new UpdateContractTypeUseCase(
        contractTypeRepository,
        securityFacade,
        contractTypeMapper);

    return new ContractTypeFacade(
        searchContractTypeUseCase,
        createContractTypeUseCase,
        deleteContractTypeUseCase,
        updateContractTypeUseCase);
  }
}
