package com.draczek.SystemOgloszeniowy.workingTimeType;

import com.draczek.SystemOgloszeniowy.workingTimeType.domain.command.WorkingTimeTypeFacade;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.CreateWorkingTimeTypeDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.UpdateWorkingTimeTypeDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.WorkingTimeTypeDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * WorkingTimeType's package controller.
 */
@RestController
@RequestMapping(value = "/api/workingTimeTypes")
@RequiredArgsConstructor
public class WorkingTimeTypeController {
  private final WorkingTimeTypeFacade workingTimeTypeFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " typów wymiaru pracy")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<WorkingTimeTypeDto> searchWorkingTimeTypes() {
    return workingTimeTypeFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych typów wymiaru pracy")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public WorkingTimeTypeDto createWorkingTimeType(@RequestBody CreateWorkingTimeTypeDto dto) {
    return workingTimeTypeFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania typów wymiaru pracy")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteWorkingTimeType(@PathVariable(name = "uuid") UUID uuid) {
    workingTimeTypeFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji typów wymiaru pracy")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateWorkingTimeType(@PathVariable(name = "uuid") UUID uuid,
                                    @RequestBody UpdateWorkingTimeTypeDto dto) {
    workingTimeTypeFacade.update(uuid, dto);
  }
}