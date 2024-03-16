package com.draczek.SystemOgloszeniowy.accountLink;

import com.draczek.SystemOgloszeniowy.accountLink.domain.command.AccountLinkFacade;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.AccountLinkDto;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.CreateAccountLinkDto;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.UpdateAccountLinkDto;
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
 * Account link's package controller.
 */
@RestController
@RequestMapping(value = "/api/accountLinks")
@RequiredArgsConstructor
@Slf4j
public class AccountLinkController {
  private final AccountLinkFacade accountLinkFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy powiązanych linków użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AccountLinkDto> searchAccountLinks() {
    return accountLinkFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych powiązanych linków użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AccountLinkDto createAccountLink(
      @RequestBody CreateAccountLinkDto dto) {
    return accountLinkFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania powiązanych linków użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountLink(@PathVariable(name = "uuid") UUID uuid) {
    accountLinkFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji powiązanych linków użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAccountLink(@PathVariable(name = "uuid") UUID uuid,
                                @RequestBody UpdateAccountLinkDto dto) {
    accountLinkFacade.update(uuid, dto);
  }
}
