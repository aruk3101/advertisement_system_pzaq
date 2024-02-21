package com.draczek.SystemOgloszeniowy.educationLevel.domain;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.command.EducationLevelFacade;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.CreateEducationLevelDto;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.EducationLevelDto;
import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.UpdateEducationLevelDto;
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
 * Education Level's package controller.
 */
@RestController
@RequestMapping(value = "/api/educationLevels")
@RequiredArgsConstructor
@Slf4j
public class EducationLevelController {
  private final EducationLevelFacade educationLevelFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie poziomów wykształcenia")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<EducationLevelDto> searchEducationLevels() {
    return educationLevelFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych poziomow wyksztalcenia")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public EducationLevelDto createEducationLevel(@RequestBody CreateEducationLevelDto dto) {
    return educationLevelFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania poziomów wykształcenia")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteEducationLevel(@PathVariable(name = "uuid") UUID uuid) {
    educationLevelFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji poziomów wykształcenia")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateEducationLevel(@PathVariable(name = "uuid") UUID uuid,
                                   @RequestBody UpdateEducationLevelDto dto) {
    educationLevelFacade.update(uuid, dto);
  }
}
