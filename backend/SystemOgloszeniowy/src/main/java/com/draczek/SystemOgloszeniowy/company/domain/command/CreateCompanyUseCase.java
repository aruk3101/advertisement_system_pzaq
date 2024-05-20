package com.draczek.SystemOgloszeniowy.company.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.command.Address;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.company.domain.dto.CompanyDto;
import com.draczek.SystemOgloszeniowy.company.domain.dto.CreateCompanyDto;
import com.draczek.SystemOgloszeniowy.user.domain.enumerated.SystemUserIdEnum;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * CreateCompanyUseCase.
 */
@RequiredArgsConstructor
public class CreateCompanyUseCase {

  private final CompanyRepository companyRepository;
  private final CompanyMapper companyMapper;

  /**
   * Method for creating companies.
   *
   * @param dto CreateCompanyDto
   * @return CompanyDto
   */
  public CompanyDto create(CreateCompanyDto dto) {
    Company company = Company.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .iframeHyperlink(dto.getIframeHyperlink())
        .address(Address.builder()
            .uuid(UUID.randomUUID())
            .build())
        .description(dto.getDescription())
        .build();
    company.getAddress().setStatus(StatusEnum.ACTIVE);
    company.getAddress().setUserIdCreated(SystemUserIdEnum.SYSTEM.getId());
    company.getAddress().setUserIdLastModified(SystemUserIdEnum.SYSTEM.getId());
    company.setStatus(StatusEnum.ACTIVE);
    company.setUserIdCreated(SystemUserIdEnum.SYSTEM.getId());
    company.setUserIdLastModified(SystemUserIdEnum.SYSTEM.getId());
    return companyMapper.toDto(companyRepository.saveAndFlush(company));
  }
}
