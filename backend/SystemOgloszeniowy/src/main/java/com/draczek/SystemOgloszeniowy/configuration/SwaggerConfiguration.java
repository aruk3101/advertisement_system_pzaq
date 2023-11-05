package com.draczek.SystemOgloszeniowy.configuration;

import static com.draczek.SystemOgloszeniowy.user.domain.command.WebSecurityAuthTokenFilter.AUTHORIZATION;
import static com.draczek.SystemOgloszeniowy.user.domain.command.WebSecurityAuthTokenFilter.BEARER;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger's config.
 */
@Configuration
public class SwaggerConfiguration {

  /**
   * Bean of Swagger's OpenApi Config.
   *
   * @return OpenAPI instance
   */
  @Bean
  public OpenAPI securedOpenApi() {
    // config Swaggera, z dodanym sposobem autentykacji Bearer JWT, api key,
    // przekazywany w HEADER jako flaga AUTHORIZATION z dodanym tytułem
    return new OpenAPI()
        .components(new Components().addSecuritySchemes(BEARER + "-jwt",
            new SecurityScheme().type(SecurityScheme.Type.APIKEY).scheme(BEARER)
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name(AUTHORIZATION)))
        .info(new Info().title("Projekt szkolny na PZAW Damian Raczek ®"))
        .addSecurityItem(new SecurityRequirement().addList(BEARER + "-jwt",
            Arrays.asList("read", "write")));
  }
}