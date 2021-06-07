package eu.wings.ditect.domain.mongo;

import lombok.RequiredArgsConstructor;

/**
 * The audit data.
 *
 * @param <T> the primary key type.
 */
@RequiredArgsConstructor
public final class AuditUser<T> {

  private final T id;
  private final String userName;
}
