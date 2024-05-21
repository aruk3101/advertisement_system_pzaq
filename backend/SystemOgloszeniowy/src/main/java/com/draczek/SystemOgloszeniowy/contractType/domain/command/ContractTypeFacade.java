package com.draczek.SystemOgloszeniowy.contractType.domain.command;

import com.draczek.SystemOgloszeniowy.contractType.domain.dto.ContractTypeDto;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.CreateContractTypeDto;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.UpdateContractTypeDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * ContractType's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class ContractTypeFacade {
  private final SearchContractTypeUseCase searchContractTypeUseCase;
  private final CreateContractTypeUseCase createContractTypeUseCase;
  private final DeleteContractTypeUseCase deleteContractTypeUseCase;
  private final UpdateContractTypeUseCase updateContractTypeUseCase;

  /**
   * Method for searching for all available ContractType.
   *
   * @return list of ContractType
   */
  public List<ContractTypeDto> search() {
    return searchContractTypeUseCase.search();
  }

  /**
   * Method for searching ContractType entity by its UUID.
   *
   * @return ContractType entity
   */
  public ContractType getEntity(UUID uuid) {
    return searchContractTypeUseCase.getEntity(uuid);
  }

  /**
   * Method for creating ContractType.
   *
   * @param dto CreateContractTypeDto
   * @return ContractTypeDto
   */
  public ContractTypeDto create(CreateContractTypeDto dto) {
    return createContractTypeUseCase.createContractTypeDto(dto);
  }

  /**
   * Method for deleting ContractType by its UUID.
   *
   * @param uuid ContractType's UUID
   */
  public void delete(UUID uuid) {
    deleteContractTypeUseCase.delete(uuid);
  }

  /**
   * Method for updating ContractType entity by its UUID.
   *
   * @param uuid ContractType's UUID
   * @param dto  UpdateContractTypeDto
   * @return modified ContractTypeDto
   */
  public ContractTypeDto update(UUID uuid, UpdateContractTypeDto dto) {
    return updateContractTypeUseCase.updateDto(uuid, dto);
  }
}
