package eu.ditect.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import lombok.Data;

/**
 * The metric http request data.
 */
@Data
public final class MetricMetaRequest {
  private String partner;
  private String pilotCode;
  private String country;
  private String region;
  private boolean manufacturingProcessing;
  private boolean primaryProduction;
  private boolean distributionRetail;
  private boolean packingStage;
  private String instrumentName;
  private String typeOfAnalysis;
  private Instant createdDate;
}
