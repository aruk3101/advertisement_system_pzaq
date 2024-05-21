package com.draczek.SystemOgloszeniowy.contractType.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * ContractTypeNotFoundException entity not found exception.
 */
public final class ContractTypeNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "contract_type_not_found";

  public ContractTypeNotFoundException(UUID uuid) {
    super(String.format("Could not find Contract type with UUID: %s", uuid), DEFAULT_CODE);
  }
}
