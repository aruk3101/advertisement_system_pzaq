package com.draczek.SystemOgloszeniowy.positionLevel;

import com.draczek.SystemOgloszeniowy.positionLevel.domain.command.PositionLevelFacade;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.CreatePositionLevelDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.UpdatePositionLevelDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
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
 * Position Level's package controller.
 */
@RestController
@RequestMapping(value = "/api/positionLevels")
@RequiredArgsConstructor
public class PositionLevelController {
  private final PositionLevelFacade positionLevelFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " poziomów stanowisk")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<PositionLevelDto> searchPositionLevels() {
    return positionLevelFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych poziomow stanowisk")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public PositionLevelDto createPositionLevel(@RequestBody CreatePositionLevelDto dto) {
    return positionLevelFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania poziomów stanowisk")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deletePositionLevel(@PathVariable(name = "uuid") UUID uuid) {
    positionLevelFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji poziomów stanowisk")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updatePositionLevel(@PathVariable(name = "uuid") UUID uuid,
                                  @RequestBody UpdatePositionLevelDto dto) {
    positionLevelFacade.update(uuid, dto);
  }
}

