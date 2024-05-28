package com.draczek.SystemOgloszeniowy.advertisementRequirements;

import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command.AdvertisementRequirementFacade;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.AdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.CreateAdvertisementRequirementDto;
import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.UpdateAdvertisementRequirementDto;
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
 * AdvertisementRequirement's package controller.
 */
@RestController
@RequestMapping(value = "/api/advertisementRequirements")
@RequiredArgsConstructor
public class AdvertisementRequirementController {
  private final AdvertisementRequirementFacade advertisementRequirementFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " wymagań w ogłoszeniu")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AdvertisementRequirementDto> searchAdvertisementRequirements() {
    return advertisementRequirementFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych wymagań w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AdvertisementRequirementDto createAdvertisementRequirements(
      @RequestBody CreateAdvertisementRequirementDto dto) {
    return advertisementRequirementFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania wymagań w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAdvertisementRequirements(@PathVariable(name = "uuid") UUID uuid) {
    advertisementRequirementFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji wymagań w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAdvertisementRequirements(@PathVariable(name = "uuid") UUID uuid,
                                              @RequestBody UpdateAdvertisementRequirementDto dto) {
    advertisementRequirementFacade.update(uuid, dto);
  }
}
