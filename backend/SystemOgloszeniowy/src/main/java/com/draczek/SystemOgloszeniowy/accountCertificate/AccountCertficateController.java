package com.draczek.SystemOgloszeniowy.accountCertificate;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.command.AccountCertificateFacade;
import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.AccountCertificateDto;
import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.CreateAccountCertificateDto;
import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.UpdateAccountCertificateDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Account certificate's package controller.
 */
@RestController
@RequestMapping(value = "/api/accountCertificates")
@RequiredArgsConstructor
@Slf4j
public class AccountCertficateController {
  private final AccountCertificateFacade accountCertificateFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy certyfikatow użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AccountCertificateDto> searchAccountCertificates() {
    return accountCertificateFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych certyfikatów użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AccountCertificateDto createAccountCertificate(
      @RequestBody CreateAccountCertificateDto dto) {
    return accountCertificateFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania certyfikatów użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountCertificate(@PathVariable(name = "uuid") UUID uuid) {
    accountCertificateFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji certyfikatów użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAccountCertificate(@PathVariable(name = "uuid") UUID uuid,
                                       @RequestBody UpdateAccountCertificateDto dto) {
    accountCertificateFacade.update(uuid, dto);
  }
}
