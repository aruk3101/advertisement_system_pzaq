package com.draczek.SystemOgloszeniowy.company.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * Company entity not found exception.
 */
public final class CompanyNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "company_not_found";

  public CompanyNotFoundException(UUID uuid) {
    super(String.format("Could not find Company with UUID: %s", uuid), DEFAULT_CODE);
  }
}
