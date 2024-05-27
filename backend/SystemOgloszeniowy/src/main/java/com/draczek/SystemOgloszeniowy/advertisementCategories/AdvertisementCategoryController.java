package com.draczek.SystemOgloszeniowy.advertisementCategories;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command.AdvertisementCategoryFacade;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.AdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.CreateAdvertisementCategoryDto;
import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.UpdateAdvertisementCategoryDto;
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
 * AdvertisementCategory's package controller.
 */
@RestController
@RequestMapping(value = "/api/advertisementCategories")
@RequiredArgsConstructor
public class AdvertisementCategoryController {
  private final AdvertisementCategoryFacade advertisementCategoryFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " kategori ogłoszeń")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<AdvertisementCategoryDto> searchAdvertisementCategories() {
    return advertisementCategoryFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych kategori ogłoszeń")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public AdvertisementCategoryDto createAdvertisementCategories(@RequestBody CreateAdvertisementCategoryDto dto) {
    return advertisementCategoryFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania kategori ogłoszeń")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAdvertisementCategories(@PathVariable(name = "uuid") UUID uuid) {
    advertisementCategoryFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji kategori ogłoszeń")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateAdvertisementCategories(@PathVariable(name = "uuid") UUID uuid,
                                            @RequestBody UpdateAdvertisementCategoryDto dto) {
    advertisementCategoryFacade.update(uuid, dto);
  }
}
