package com.draczek.SystemOgloszeniowy.company.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for deleting companies.
 */
@RequiredArgsConstructor
public class DeleteCompanyUseCase {
  private final CompanyRepository companyRepository;

  /**
   * Method for deleting companies.
   *
   * @param uuid UUID
   */
  public void delete(UUID uuid) {
    Company company = companyRepository.get(uuid);
    companyRepository.delete(company);
  }
}
