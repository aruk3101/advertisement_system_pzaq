package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.user.domain.dto.JwtDto;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Utils for JWT tokens.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtils {

  private final JwtProperties jwtProperties;

  /**
   * Method for token generation.
   *
   * @param username user name
   * @return dto JwtDto
   */
  public JwtDto generateTokenFromUsername(String username) {
    Date issuedAt = new Date();
    Date expiration = new Date(issuedAt.getTime() + jwtProperties.getExpirationMs());
    String token = Jwts.builder()
        .setSubject(username)
        .setIssuedAt(issuedAt)
        .setExpiration(expiration)
        .signWith(decodeSecret(), SignatureAlgorithm.HS512)
        .compact();
    return new JwtDto(token, expiration);
  }

  /**
   * Method for getting username from JWT token.
   *
   * @param token token JWT.
   * @return username
   */
  public String getUsernameFromJwtToken(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(decodeSecret())
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  /**
   * Method to verify JWT token.
   *
   * @param token token JWT.
   * @return indicates if token is valid
   */
  public boolean validateJwtToken(String token) {
    try {
      String username = getUsernameFromJwtToken(token);
      return username != null && !username.isEmpty();
    } catch (SignatureException e) {
      log.error("Token: '{}' - Invalid JWT signature: {}", token, e.getMessage());
    } catch (MalformedJwtException e) {
      log.error("Token: '{}' - Invalid JWT token: {}", token, e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("Token: '{}' - JWT token is expired: {}", token, e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("Token: '{}' - JWT token is unsupported: {}", token, e.getMessage());
    } catch (IllegalArgumentException e) {
      log.error("Token: '{}' - JWT claims string is empty: {}", token, e.getMessage());
    }
    return false;
  }

  /**
   * Method for decoding JWT's secret key.
   *
   * @return Decoded SecretKey instance.
   */
  private SecretKey decodeSecret() {
    byte[] bytes = Decoders.BASE64.decode(jwtProperties.getSecret());
    /*
      Ta część kodu służy do utworzenia klucza HMAC (Hash-based Message Authentication Code)
      na podstawie zdekodowanego tajnego klucza JWT. Klucz HMAC jest wykorzystywany do podpisywania
      i weryfikacji tokenów JWT. W praktyce tajny klucz JWT jest przekształcany w klucz HMAC,
      który jest bardziej odpowiedni do używania w kontekście podpisywania tokenów JWT.
      Ostatecznie klucz HMAC jest używany do zabezpieczenia tokenów JWT poprzez dodawanie
      sygnatury do nich, co pozwala na weryfikację ich autentyczności.
     */
    return Keys.hmacShaKeyFor(bytes);
  }
}