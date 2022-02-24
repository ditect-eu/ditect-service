package eu.ditect.config;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String ACTUATOR_PATTERN = "/actuator/**";

  @Value("${jwk-set-uri}")
  private String jwkSetUri;
  @Value("${allowed-origins}")
  private String[] allowedOrigins;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().ignoringAntMatchers(ACTUATOR_PATTERN)
        .and()
        .authorizeRequests(authorizeRequests -> authorizeRequests
            .mvcMatchers(ACTUATOR_PATTERN)
            .permitAll()
            .anyRequest()
            .authenticated())
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
  }

  @Bean
  JwtDecoder jwtDecoder() {
    return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
  }

  //TODO: only @Profile("dev")
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    var configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Stream.of(allowedOrigins).collect(toList()));
    configuration.setAllowedMethods(List.of("*"));
    configuration.setAllowedHeaders(List.of("*"));
    var source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}

