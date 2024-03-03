package com.draczek.SystemOgloszeniowy.accountLink.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AccountLinkNotFoundException entity not found exception.
 */
public final class AccountLinkNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "account_link_not_found";

  public AccountLinkNotFoundException(UUID uuid) {
    super(String.format("Could not find Account Link with UUID: %s", uuid), DEFAULT_CODE);
  }
}
