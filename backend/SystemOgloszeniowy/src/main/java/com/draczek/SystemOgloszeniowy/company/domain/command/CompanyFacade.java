package com.draczek.SystemOgloszeniowy.company.domain.command;

import com.draczek.SystemOgloszeniowy.company.domain.dto.CompanyDto;
import com.draczek.SystemOgloszeniowy.company.domain.dto.CreateCompanyDto;
import com.draczek.SystemOgloszeniowy.company.domain.dto.UpdateCompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Company's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class CompanyFacade {
  private final SearchCompaniesUseCase searchCompaniesUseCase;
  private final CreateCompanyUseCase createCompanyUseCase;
  private final UpdateCompanyUseCase updateCompanyUseCase;
  private final DeleteCompanyUseCase deleteCompanyUseCase;

  /**
   * Method for searching companies.
   *
   * @param pageable Pageable
   * @return CompanyDto page
   */
  public Page<CompanyDto> search(Pageable pageable) {
    return searchCompaniesUseCase.search(pageable);
  }

  /**
   * Method for searching companies.
   *
   * @param uuid UUID
   * @return Company
   */
  public Company getEntity(UUID uuid) {
    return searchCompaniesUseCase.getEntity(uuid);
  }

  /**
   * Method for searching companies by UUID.
   *
   * @param uuid UUID
   * @return CompanyDto
   */
  public CompanyDto get(UUID uuid) {
    return searchCompaniesUseCase.get(uuid);
  }


  /**
   * Method for creating companies.
   *
   * @param dto CreateCompanyDto
   * @return CompanyDto
   */
  public CompanyDto create(CreateCompanyDto dto) {
    return createCompanyUseCase.create(dto);
  }

  /**
   * Method for updating companies.
   *
   * @param dto UpdateCompanyDto
   * @return CompanyDto
   */
  public CompanyDto update(UpdateCompanyDto dto, UUID uuid) {
    return updateCompanyUseCase.update(dto, uuid);
  }

  /**
   * Method for deleting companies.
   *
   * @param uuid UUID
   */
  public void delete(UUID uuid) {
    deleteCompanyUseCase.delete(uuid);
  }
}
