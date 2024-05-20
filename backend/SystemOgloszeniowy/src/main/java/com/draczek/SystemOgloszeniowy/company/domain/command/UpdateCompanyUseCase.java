package com.draczek.SystemOgloszeniowy.company.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.command.AddressFacade;
import com.draczek.SystemOgloszeniowy.company.domain.dto.CompanyDto;
import com.draczek.SystemOgloszeniowy.company.domain.dto.UpdateCompanyDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class for updating Comapnies.
 */
@RequiredArgsConstructor
@Slf4j
public class UpdateCompanyUseCase {
  private final CompanyRepository companyRepository;
  private final CompanyMapper companyMapper;
  private final AddressFacade addressFacade;

  /**
   * Method for updating Comapnies.
   *
   * @param dto  UpdateCompanyDto
   * @param uuid UUID
   * @return CompanyDto
   */
  public CompanyDto update(UpdateCompanyDto dto, UUID uuid) {
    Company company = companyRepository.get(uuid);
    company.setVersion(dto.getVersion());
    company.setName(dto.getName());
    company.setDescription(dto.getDescription());
    company.setIframeHyperlink(dto.getIframeHyperlink());
    company.setAddress(addressFacade.update(dto.getUpdateAddressDto(),
        company.getAddress().getUuid()));
    return companyMapper.toDto(companyRepository.saveAndFlush(company));
  }
}
