package eu.wings.ditect.config;

import eu.wings.ditect.domain.mongo.AuditUser;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
class AuditConfig implements AuditorAware<AuditUser<String>> {

  private static final String JWT_USER_NAME = "preferred_username";

  @Override
  public Optional<AuditUser<String>> getCurrentAuditor() {
    return Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated)
        .map(auth -> (Jwt) auth.getPrincipal())
        .map(jwt -> new AuditUser(jwt.getSubject(), jwt.getClaimAsString(JWT_USER_NAME)));
  }
}
