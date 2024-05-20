package com.draczek.SystemOgloszeniowy.company;

import com.draczek.SystemOgloszeniowy.company.domain.command.CompanyFacade;
import com.draczek.SystemOgloszeniowy.company.domain.dto.CompanyDto;
import com.draczek.SystemOgloszeniowy.company.domain.dto.CreateCompanyDto;
import com.draczek.SystemOgloszeniowy.company.domain.dto.UpdateCompanyDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * company's package controller.
 */
@RestController
@RequestMapping(value = "/api/companies")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {
  private final CompanyFacade companyFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania przedsiębiorstw.")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public Page<CompanyDto> searchCompanies(Pageable pageable) {
    return companyFacade.search(pageable);
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych przedsiębiorstw.")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public CompanyDto createCompany(
      @RequestBody CreateCompanyDto dto) {
    return companyFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania przedsiębiorsw.")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteCompany(@PathVariable(name = "uuid") UUID uuid) {
    companyFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji przedsiębiorstw.")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public CompanyDto updateCompany(@PathVariable(name = "uuid") UUID uuid,
                            @RequestBody UpdateCompanyDto dto) {
    return companyFacade.update(dto, uuid);
  }
}
