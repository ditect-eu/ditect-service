package eu.ditect.domain;

import java.time.Instant;
import lombok.Value;

/**
 * Range of dates (from -> to).
 */
@Value
public final class DateRange {

  private final Instant from;
  private final Instant to;
}
