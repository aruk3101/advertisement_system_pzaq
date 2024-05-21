package com.draczek.SystemOgloszeniowy.contractType.domain.command;

import com.draczek.SystemOgloszeniowy.contractType.domain.dto.ContractTypeDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching ContractType.
 */
@RequiredArgsConstructor
public class SearchContractTypeUseCase {
  private final ContractTypeMapper contractTypeMapper;
  private final ContractTypeRepository contractTypeRepository;

  public List<ContractTypeDto> search() {
    return contractTypeRepository.findAll().stream().map(contractTypeMapper::toDto).toList();
  }

  public ContractType getEntity(UUID uuid) {
    return contractTypeRepository.get(uuid);
  }
}
