package com.draczek.SystemOgloszeniowy.accountCertificate.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AccountCertificateNotFoundException entity not found exception.
 */
public final class AccountCertificateNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "account_certificate_not_found";

  public AccountCertificateNotFoundException(UUID uuid) {
    super(String.format("Could not find Account Certificate with UUID: %s", uuid), DEFAULT_CODE);
  }
}
