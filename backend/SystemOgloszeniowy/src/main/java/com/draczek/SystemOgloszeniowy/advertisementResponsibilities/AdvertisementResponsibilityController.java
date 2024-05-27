package com.draczek.SystemOgloszeniowy.advertisementResponsibilities;

import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command.AdvertisementResponsibilityFacade;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.AdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.CreateAdvertisementResponsibilityDto;
import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.UpdateAdvertisementResponsibilityDto;
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
 * AdvertisementResponsibility's package controller.
 */
@RestController
@RequestMapping(value = "/api/advertisementResponsibilities")
@RequiredArgsConstructor
public class AdvertisementResponsibilityController {
  private final AdvertisementResponsibilityFacade advertisementResponsibilityFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " obowiązków w ogłoszeniu")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AdvertisementResponsibilityDto> searchAdvertisementResponsibilities() {
    return advertisementResponsibilityFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych obowiązków w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AdvertisementResponsibilityDto createAdvertisementResponsibilities(
      @RequestBody CreateAdvertisementResponsibilityDto dto) {
    return advertisementResponsibilityFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania obowiązków w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAdvertisementResponsibilities(@PathVariable(name = "uuid") UUID uuid) {
    advertisementResponsibilityFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji obowiązków w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAdvertisementResponsibilities(@PathVariable(name = "uuid") UUID uuid,
                                                  @RequestBody UpdateAdvertisementResponsibilityDto dto) {
    advertisementResponsibilityFacade.update(uuid, dto);
  }
}
