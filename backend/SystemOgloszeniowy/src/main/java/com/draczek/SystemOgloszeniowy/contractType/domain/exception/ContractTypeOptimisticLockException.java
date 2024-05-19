package com.draczek.SystemOgloszeniowy.contractType.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of ContractType's invalid version exception.
 */
public class ContractTypeOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "contract_type_optimistic_lock";

  public ContractTypeOptimisticLockException() {
    super("Version of ContractType is invalid", DEFAULT_CODE);
  }
}