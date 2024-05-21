package com.draczek.SystemOgloszeniowy.contractType.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting ContractType entities.
 */
@RequiredArgsConstructor
public class DeleteContractTypeUseCase {
  private final ContractTypeRepository contractTypeRepository;

  public void delete(UUID uuid) {
    ContractType positionLevel = contractTypeRepository.get(uuid);
    contractTypeRepository.delete(positionLevel);
  }

}