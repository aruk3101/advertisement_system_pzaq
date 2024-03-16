package com.draczek.SystemOgloszeniowy.accountEducation;

import com.draczek.SystemOgloszeniowy.accountEducation.domain.command.AccountEducationFacade;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.AccountEducationDto;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.CreateAccountEducationDto;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.UpdateAccountEducationDto;
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
 * Account education's package controller.
 */
@RestController
@RequestMapping(value = "/api/accountEducations")
@RequiredArgsConstructor
@Slf4j
public class AccountEducationController {
  private final AccountEducationFacade accountEducationFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania wyształcenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AccountEducationDto> searchAccountEducations() {
    return accountEducationFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia wyształcenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AccountEducationDto createAccountEducation(
      @RequestBody CreateAccountEducationDto dto) {
    return accountEducationFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania wyształcenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountEducation(@PathVariable(name = "uuid") UUID uuid) {
    accountEducationFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji wyształcenia zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAccountEducation(@PathVariable(name = "uuid") UUID uuid,
                                     @RequestBody UpdateAccountEducationDto dto) {
    accountEducationFacade.update(uuid, dto);
  }
}
