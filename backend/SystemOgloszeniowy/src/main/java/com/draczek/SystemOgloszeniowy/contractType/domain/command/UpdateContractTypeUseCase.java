package com.draczek.SystemOgloszeniowy.contractType.domain.command;

import com.draczek.SystemOgloszeniowy.contractType.domain.dto.ContractTypeDto;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.UpdateContractTypeDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating ContractType.
 */
@RequiredArgsConstructor
public class UpdateContractTypeUseCase {
  private final ContractTypeRepository contractTypeRepository;
  private final SecurityFacade securityFacade;
  private final ContractTypeMapper contractTypeMapper;

  /**
   * Method for updating ContractType.
   *
   * @param uuid ContractType's UUID
   * @param dto  UpdateContractTypeDto
   * @return modified ContractTypeDto
   */
  public ContractTypeDto updateDto(UUID uuid, UpdateContractTypeDto dto) {
    return contractTypeMapper.toDto(update(uuid, dto));
  }

  private ContractType update(UUID uuid, UpdateContractTypeDto dto) {
    ContractType contractType = contractTypeRepository.get(uuid);
    contractType.setName(dto.getName());
    contractType.setVersion(dto.getVersion());
    contractType.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return contractTypeRepository.saveAndFlush(contractType);
  }
}