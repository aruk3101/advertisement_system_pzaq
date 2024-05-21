package com.draczek.SystemOgloszeniowy.contractType.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.ContractTypeDto;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.CreateContractTypeDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating ContractType.
 */

@RequiredArgsConstructor
public class CreateContractTypeUseCase {
  private final SecurityFacade securityFacade;
  private final ContractTypeRepository contractTypeRepository;
  private final ContractTypeMapper contractTypeMapper;

  /**
   * Method for creating ContractType.
   *
   * @param dto CreateContractTypeDto
   * @return ContractTypeDto dto
   */
  public ContractTypeDto createContractTypeDto(CreateContractTypeDto dto) {
    return contractTypeMapper.toDto(createLanguageLevel(dto));
  }

  private ContractType createLanguageLevel(CreateContractTypeDto dto) {
    ContractType positionLevel = ContractType.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .build();
    positionLevel.setStatus(StatusEnum.ACTIVE);
    positionLevel.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    positionLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return contractTypeRepository.saveAndFlush(positionLevel);
  }
}
