package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.configuration.ServerProperties;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Security configuration class.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig {

  private static final String[] AUTH_WHITELIST = {
      "/upload/**",
      "/api/auth/login",
      "/api/auth/register",
      "/api/auth/activate",
      "/api/auth/reset-password/step-1",
      "/api/auth/reset-password/step-2",
      "/swagger-resources/**",
      "/swagger-ui*",
      "/swagger-ui/**",
      "/v3/api-docs*",
      "/v3/api-docs/**",
      "/webjars/**"
  };

  private final SearchUserDetailsUseCase userDetailsService;
  private final WebSecurityAuthEntryPointJwt unauthorizedHandler;
  private final ServerProperties serverProperties;

  /**
   * WebSecurityConfig auto wired constructor.
   *
   * @param userDetailsService UserDetails service class
   * @param unauthorizedHandler unauthorized errors handler
   * @param serverProperties server properties
   */
  @Autowired
  public WebSecurityConfig(
      SearchUserDetailsUseCase userDetailsService,
      WebSecurityAuthEntryPointJwt unauthorizedHandler,
      ServerProperties serverProperties) {
    this.userDetailsService = userDetailsService;
    this.unauthorizedHandler = unauthorizedHandler;
    this.serverProperties = serverProperties;
  }

  @Bean
  public WebSecurityAuthTokenFilter authenticationJwtTokenFilter() {
    return new WebSecurityAuthTokenFilter();
  }

  /**
   * Return Data Access Object of authentication provider.
   *
   * @return DaoAuthenticationProvider instance.
   */
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig)
      throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Method, that returns security filter chain.
   *
   * @param http HttpSecurity object
   * @return SecurityFilterChain instance
   * @throws Exception cors exception
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
        .anyRequest().authenticated();
    http.authenticationProvider(authenticationProvider());
    http.addFilterBefore(authenticationJwtTokenFilter(),
        UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  /**
   * Method, that creates a cors filter, based on provided configuration.
   *
   * @return FilterRegistrationBean instance
   */
  @Bean
  public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
    CorsConfiguration config = new CorsConfiguration();
    // Allowed origins * is there because it's a school project,
    // and I need to have some flexibility using it.
    // Normally I'd make a property with a front-end server url.
    config.setAllowCredentials(true);
    config.setAllowedOriginPatterns(Collections.singletonList("*"));
    config.setAllowedMethods(Collections.singletonList("*"));
    config.setAllowedHeaders(Collections.singletonList("*"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
  }
}