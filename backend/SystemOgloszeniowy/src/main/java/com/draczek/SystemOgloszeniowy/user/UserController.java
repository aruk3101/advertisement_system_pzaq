package com.draczek.SystemOgloszeniowy.user;

import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * User's package controller.
 */
@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {
  private final UserFacade userFacade;

  @GetMapping("/test")
  @Operation(summary = "Testowa usługa")
  @ResponseStatus(HttpStatus.OK)
  public UserDto test() {
    return userFacade.test();
  }
}
