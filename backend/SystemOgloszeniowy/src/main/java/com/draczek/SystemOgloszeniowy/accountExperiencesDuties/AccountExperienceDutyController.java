package com.draczek.SystemOgloszeniowy.accountExperiencesDuties;

import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command.AccountExperienceDutyFacade;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.AccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.CreateAccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.UpdateAccountExperienceDutyDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Account experience duty's package controller.
 */
@RestController
@RequestMapping(value = "/api/accountExperiencesDuties")
@RequiredArgsConstructor
@Slf4j
public class AccountExperienceDutyController {
  private final AccountExperienceDutyFacade accountExperienceDutyFacade;

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia obowiązków doświadczenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AccountExperienceDutyDto createAccountExperienceDuty(
      @RequestBody CreateAccountExperienceDutyDto dto) {
    return accountExperienceDutyFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania obowiązków doświadczenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountExperienceDuty(@PathVariable(name = "uuid") UUID uuid) {
    accountExperienceDutyFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji obowiązków doświadczenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAccountExperienceDuty(@PathVariable(name = "uuid") UUID uuid,
                                          @RequestBody UpdateAccountExperienceDutyDto dto) {
    accountExperienceDutyFacade.update(uuid, dto);
  }
}