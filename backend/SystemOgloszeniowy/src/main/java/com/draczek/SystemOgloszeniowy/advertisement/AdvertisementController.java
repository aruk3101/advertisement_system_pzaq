package com.draczek.SystemOgloszeniowy.advertisement;

import com.draczek.SystemOgloszeniowy.advertisement.domain.command.AdvertisementFacade;
import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.AdvertisementDto;
import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.CreateAdvertisementDto;
import com.draczek.SystemOgloszeniowy.advertisement.domain.dto.UpdateAdvertisementDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * AdvertisementFacade's package controller.
 */
@RestController
@RequestMapping(value = "/api/advertisements")
@RequiredArgsConstructor
public class AdvertisementController {
  private final AdvertisementFacade advertisementFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " ogłoszeń")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public Page<AdvertisementDto> searchAdvertisements(
      Pageable pageable) {
    return advertisementFacade.search(pageable);
  }

  @GetMapping("/{uuid}")
  @Operation(summary = "Usługa do pobierania ogłoszenia po jego UUID")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public AdvertisementDto searchAdvertisements(@PathVariable UUID uuid) {
    return advertisementFacade.get(uuid);
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych ogłoszeń")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AdvertisementDto createAdvertisements(@RequestBody CreateAdvertisementDto dto) {
    return advertisementFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania ogłoszeń")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAdvertisements(@PathVariable(name = "uuid") UUID uuid) {
    advertisementFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji ogłoszeń")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAdvertisements(@PathVariable(name = "uuid") UUID uuid,
                                   @RequestBody UpdateAdvertisementDto dto) {
    advertisementFacade.update(uuid, dto);
  }
}
