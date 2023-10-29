package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.auth.command.dto.LoginDto;
import com.draczek.SystemOgloszeniowy.user.domain.command.JwtUtils;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserDetailsImpl;
import com.draczek.SystemOgloszeniowy.user.domain.dto.JwtDto;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UserTokenDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Class for logging in the user.
 */
@RequiredArgsConstructor
public class LoginUseCase {
  private final JwtUtils jwtUtils;
  private final AuthenticationManager authenticationManager;

  /**
   * Method for logging in.
   */
  public UserTokenDto login(@NotNull LoginDto dto) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),
            dto.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    JwtDto jwt = jwtUtils.generateTokenFromUsername(userDetails.getUsername());
    List<String> roles = userDetails.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());
    return new UserTokenDto(
        userDetails.getUuid(),
        userDetails.getUsername(),
        roles,
        jwt.getToken(),
        jwt.getExpiration());
  }
}
