package com.draczek.SystemOgloszeniowy.accountExperience;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.command.AccountExperienceFacade;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.AccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.CreateAccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.UpdateAccountExperienceDto;
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
 * Account experience's package controller.
 */
@RestController
@RequestMapping(value = "/api/accountExperiences")
@RequiredArgsConstructor
@Slf4j
public class AccountExperienceController {
  private final AccountExperienceFacade accountExperienceFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania doświadczenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AccountExperienceDto> searchAccountExperience() {
    return accountExperienceFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia doświadczenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AccountExperienceDto createAccountExperience(
      @RequestBody CreateAccountExperienceDto dto) {
    return accountExperienceFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania doświadczenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountExperience(@PathVariable(name = "uuid") UUID uuid) {
    accountExperienceFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji doświadczenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAccountExperience(@PathVariable(name = "uuid") UUID uuid,
                                      @RequestBody UpdateAccountExperienceDto dto) {
    accountExperienceFacade.update(uuid, dto);
  }
}
