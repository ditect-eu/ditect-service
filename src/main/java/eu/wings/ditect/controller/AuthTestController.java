package eu.wings.ditect.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whoami")
public class AuthTestController {

  @GetMapping
  public ResponseEntity<Map<String, Object>> whoami(@AuthenticationPrincipal Jwt jwt) {
    var result = new HashMap(jwt.getClaims());
    result.put("expiresAt", jwt.getExpiresAt());

    return ResponseEntity.ok(result);
  }
}