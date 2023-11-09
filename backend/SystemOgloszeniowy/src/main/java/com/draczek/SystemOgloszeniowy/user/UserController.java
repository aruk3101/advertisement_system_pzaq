package com.draczek.SystemOgloszeniowy.user;

import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UpdateAccountDto;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * User's package controller.
 */
@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserFacade userFacade;

  @GetMapping("/test")
  @Operation(summary = "Testowa usługa")
  @PreAuthorize("hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public UserDto test() {
    return userFacade.test();
  }

  @GetMapping("/info")
  @Operation(summary = "Testowa usługa")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public UserDto info() {
    return userFacade.info();
  }

  @PostMapping(value = "/account")
  @Operation(summary = "Usługa do zmiany danych konta zalogowanego użytkownika")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public UserDto update(@RequestBody UpdateAccountDto updateAccountDto) {
    return userFacade.update(updateAccountDto);
  }

  @PostMapping(value = "/account/pfp", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @Operation(summary = "Usługa do zmiany zdjęcia profilowego zalogowanego użytkownika.")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public UserDto updateProfilePicture(@Schema(type = "string", format = "binary")
                                      @RequestPart(name = "pfp") MultipartFile multipartFile) {
    log.info("Received file through multipart/form-data : " + multipartFile.getOriginalFilename());
    return userFacade.update(multipartFile);
  }

  @DeleteMapping(value = "/account/pfp")
  @Operation(summary = "Usługa do usunięcia zdjęcia profilowego zalogowanego użytkownika.")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public UserDto deleteProfilePicture() {
    return userFacade.deleteProfilePicture();
  }
}
