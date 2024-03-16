package com.draczek.SystemOgloszeniowy.accountLanguage;

import com.draczek.SystemOgloszeniowy.accountLanguage.domain.command.AccountLanguageFacade;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.AccountLanguageDto;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.CreateAccountLanguageDto;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.UpdateAccountLanguageDto;
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
 * Account language's package controller.
 */
@RestController
@RequestMapping(value = "/api/accountLanguages")
@RequiredArgsConstructor
@Slf4j
public class AccountLanguageController {
  private final AccountLanguageFacade accountLanguageFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania opanowanych języków zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AccountLanguageDto> searchAccountLanguages() {
    return accountLanguageFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia opanowanych języków zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AccountLanguageDto createAccountLanguage(
      @RequestBody CreateAccountLanguageDto dto) {
    return accountLanguageFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania opanowanych języków zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountLanguage(@PathVariable(name = "uuid") UUID uuid) {
    accountLanguageFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji opanowanych języków zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAccountLanguage(@PathVariable(name = "uuid") UUID uuid,
                                    @RequestBody UpdateAccountLanguageDto dto) {
    accountLanguageFacade.update(uuid, dto);
  }
}
