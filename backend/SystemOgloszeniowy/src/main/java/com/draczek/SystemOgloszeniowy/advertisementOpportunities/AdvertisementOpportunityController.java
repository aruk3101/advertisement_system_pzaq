package com.draczek.SystemOgloszeniowy.advertisementOpportunities;

import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command.AdvertisementOpportunityFacade;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.AdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.CreateAdvertisementOpportunityDto;
import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.UpdateAdvertisementOpportunityDto;
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
 * AdvertisementOpportunity's package controller.
 */
@RestController
@RequestMapping(value = "/api/advertisementOpportunities")
@RequiredArgsConstructor
public class AdvertisementOpportunityController {
  private final AdvertisementOpportunityFacade advertisementOpportunityFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " korzyści w ogłoszeniu")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AdvertisementOpportunityDto> searchAdvertisementOpportunities() {
    return advertisementOpportunityFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych korzyści w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AdvertisementOpportunityDto createAdvertisementOpportunities(
      @RequestBody CreateAdvertisementOpportunityDto dto) {
    return advertisementOpportunityFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania korzyści w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAdvertisementOpportunities(@PathVariable(name = "uuid") UUID uuid) {
    advertisementOpportunityFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji korzyści w ogłoszeniu")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAdvertisementOpportunities(@PathVariable(name = "uuid") UUID uuid,
                                               @RequestBody UpdateAdvertisementOpportunityDto dto) {
    advertisementOpportunityFacade.update(uuid, dto);
  }
}
