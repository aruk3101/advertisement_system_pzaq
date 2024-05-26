package com.draczek.SystemOgloszeniowy.company.domain.command;

import com.draczek.SystemOgloszeniowy.company.domain.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * SearchCompaniesUseCase.
 */
@RequiredArgsConstructor
public class SearchCompaniesUseCase {
  private final CompanyRepository companyRepository;
  private final CompanyMapper companyMapper;

  /**
   * Method for searching companies.
   *
   * @param pageable Pageable
   * @return CompanyDto page
   */
  public Page<CompanyDto> search(Pageable pageable) {
    return companyRepository.findAll(pageable).map(companyMapper::toDto);
  }

  public Company get(UUID uuid) {
    return companyRepository.get(uuid);
  }
}
