package com.draczek.SystemOgloszeniowy.languageLevel;

import com.draczek.SystemOgloszeniowy.languageLevel.domain.command.LanguageLevelFacade;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.CreateLanguageLevelDto;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.LanguageLevelDto;
import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.UpdateLanguageLevelDto;
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
 * Language Level's package controller.
 */
@RestController
@RequestMapping(value = "/api/languageLevels")
@RequiredArgsConstructor
@Slf4j
public class LanguageLevelController {
  private final LanguageLevelFacade languageLevelFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " poziomów znajomości języka")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<LanguageLevelDto> searchLanguageLevels() {
    return languageLevelFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych poziomow znajomości języka")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public LanguageLevelDto createLanguageLevel(@RequestBody CreateLanguageLevelDto dto) {
    return languageLevelFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania poziomów znajomości języka")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteLanguageLevel(@PathVariable(name = "uuid") UUID uuid) {
    languageLevelFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji poziomów znajomości języka")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateLanguageLevel(@PathVariable(name = "uuid") UUID uuid,
                                   @RequestBody UpdateLanguageLevelDto dto) {
    languageLevelFacade.update(uuid, dto);
  }
}
