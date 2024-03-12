package com.draczek.SystemOgloszeniowy.accountSkill;

import com.draczek.SystemOgloszeniowy.accountSkill.domain.command.AccountSkillFacade;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.AccountSkillDto;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.CreateAccountSkillDto;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.UpdateAccountSkillDto;
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
 * Account skill's package controller.
 */
@RestController
@RequestMapping(value = "/api/accountSkills")
@RequiredArgsConstructor
@Slf4j
public class AccountSkillController {
  private final AccountSkillFacade accountSkillFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy powiązanych umiejętności użytkownika.")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AccountSkillDto> searchAccountSkills() {
    return accountSkillFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych powiązanych umiejętności użytkownika.")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AccountSkillDto createAccountSkill(
      @RequestBody CreateAccountSkillDto dto) {
    return accountSkillFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania powiązanych umiejętności użytkownika.")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountSkill(@PathVariable(name = "uuid") UUID uuid) {
    accountSkillFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji powiązanych umiejętności użytkownika.")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAccountSkill(@PathVariable(name = "uuid") UUID uuid,
                                 @RequestBody UpdateAccountSkillDto dto) {
    accountSkillFacade.update(uuid, dto);
  }
}
